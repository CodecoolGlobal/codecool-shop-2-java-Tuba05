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
    HttpServletRequest mockedRequest;
    HttpServletResponse mockedResponse;
    HttpSession mockedSession;
    LoginServlet loginServlet;
    ArgumentCaptor<String> captor;

    @BeforeEach
    public void setMockedObjects() {
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        mockedSession = Mockito.mock(HttpSession.class);
    }

    @BeforeEach
    public void setLoginServlet() {
        loginServlet = new LoginServlet();
    }

    @BeforeEach
    public void setCaptor() {
        captor = ArgumentCaptor.forClass(String.class);
    }

    @Test
    void login_with_valid_username_and_password_return_true() throws ServletException, IOException {
        Mockito.when(mockedRequest.getParameter("uname")).thenReturn("Jane Doe");
        Mockito.when(mockedRequest.getParameter("psw")).thenReturn("asd");
        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        loginServlet.doPost(mockedRequest, mockedResponse);
        verify(mockedResponse).sendRedirect(captor.capture());
        Assertions.assertEquals("home", captor.getValue());
    }

    @Test
    void login_with_invalid_username_and_password_return_false() throws ServletException, IOException {
        Mockito.when(mockedRequest.getParameter("uname")).thenReturn("Invalid name");
        Mockito.when(mockedRequest.getParameter("psw")).thenReturn("123");
        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        loginServlet.doPost(mockedRequest, mockedResponse);
        verify(mockedResponse).sendRedirect(captor.capture());
        Assertions.assertNotEquals("home", captor.getValue());
    }
}