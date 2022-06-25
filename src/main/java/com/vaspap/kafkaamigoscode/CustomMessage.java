package com.vaspap.kafkaamigoscode;

import java.time.LocalDateTime;

public record CustomMessage(String message, LocalDateTime createdAt) {
}
