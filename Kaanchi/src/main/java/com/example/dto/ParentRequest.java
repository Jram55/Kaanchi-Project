
package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentRequest {
	
    private Long studentId; 
    private String parentName;
    private String gender;
    private String relationShip;
    private String mobile;
    private String email;
    private String occupation;
    private String annunalIncome;
    private String education;
    private boolean guardian;
    

   
}
