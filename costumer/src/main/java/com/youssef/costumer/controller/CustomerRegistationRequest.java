package com.youssef.costumer.controller;

public record CustomerRegistationRequest(
        String firstName,
        String lastName,
        String email
) {
}
