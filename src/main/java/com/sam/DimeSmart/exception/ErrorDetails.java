package com.sam.DimeSmart.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,
                           String msg,
                           String details,
                           String errorCode) {
}
