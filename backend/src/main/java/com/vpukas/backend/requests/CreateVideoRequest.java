package com.vpukas.backend.requests;

import com.vpukas.backend.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateVideoRequest {
    private String name;
    private Category category;
}
