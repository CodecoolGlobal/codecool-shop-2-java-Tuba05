package com.codecool.shop;

import com.codecool.shop.controller.LoginServlet;
import org.apache.struts.mock.MockHttpServletRequest;
import org.apache.struts.mock.MockHttpServletResponse;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class LoginTest {

    @Test
    void login_with_valid_username_and_password_return_true() throws ServletException, IOException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Mockito.when(request.getParameter("uname")).thenReturn("Jane Doe");
        Mockito.when(request.getParameter("psw")).thenReturn("asd");
        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.doPost(request, response);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(response).sendRedirect(captor.capture());
        Assertions.assertEquals("home", captor.getValue());
    }

    @Test
    void login_with_invalid_username_and_password_return_false() throws ServletException, IOException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        Mockito.when(request.getParameter("uname")).thenReturn("Invalid name");
        Mockito.when(request.getParameter("psw")).thenReturn("123");
        HttpSession session = Mockito.mock(HttpSession.class);
        Mockito.when(request.getSession()).thenReturn(session);
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.doPost(request, response);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(response).sendRedirect(captor.capture());
        Assertions.assertNotEquals("home", captor.getValue());
    }
}
