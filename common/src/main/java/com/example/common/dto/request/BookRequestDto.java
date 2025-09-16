package com.example.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookRequestDto {
    private long bookId;
    private String bookName;
    private String authorName;
    private String bookTitle;
    private long totalCopies;
    private double price;
}
