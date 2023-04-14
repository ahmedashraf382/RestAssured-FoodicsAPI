package com.FoodicsAPI.payload;

public class CredentialsPayload {
	private String username;
    private String password;

    public CredentialsPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
