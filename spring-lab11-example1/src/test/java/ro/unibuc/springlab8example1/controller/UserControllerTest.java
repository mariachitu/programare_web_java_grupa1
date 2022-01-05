package ro.unibuc.springlab8example1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ro.unibuc.springlab8example1.dto.UserDto;
import ro.unibuc.springlab8example1.exception.UserNotFoundException;
import ro.unibuc.springlab8example1.service.UserService;
import ro.unibuc.springlab8example1.util.UserDtoUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Testing creating the student user")
    void test_createStudent_happyFlow() throws Exception {
        //Arrange
        UserDto dto = UserDtoUtil.aUserDto("Cristina");
        when(userService.create(any(), any())).thenReturn(dto);

        //Act
        MvcResult result = mockMvc.perform(post("/users/student")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        //Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(dto));
    }

    @Test
    void test_getOneUser() throws Exception {
        String username = "Cristina";
        UserDto dto = UserDtoUtil.aUserDto(username);
        when(userService.getOne(username)).thenReturn(dto);

        mockMvc.perform(get("/users/" + username))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("username", is(dto.getUsername())))
                .andExpect(jsonPath("$.otherInformation", is(dto.getOtherInformation())));
    }

    @Test
    void test_getOneUser_Exception() throws Exception {
        String username = "Cristina";
        when(userService.getOne(username)).thenThrow(new UserNotFoundException(username));

        mockMvc.perform(get("/users/" + username))
                .andExpect(status().isNoContent());
    }

}