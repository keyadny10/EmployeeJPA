package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Manager;
import com.example.demo.service.impl.ManagerServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	ManagerServiceImpl msi;

	
	@PostMapping("/addManager")
    public String addManager(@RequestParam String username, @RequestParam String password,HttpServletRequest request) {
	 String rul=request.getRemoteHost();
        // 檢查使用者名稱是否已存在
        if (msi.managerUsername(username)) {
            return "註冊失敗：使用者名稱已存在。";
        } else {
            // 創建新的管理者並保存
            Manager newManager = new Manager(username, password);
            msi.AddManager(newManager); // 假設有 save 方法
            return "註冊成功！";
        }
    }

 
/*	@PostMapping("/login")
 public ResponseEntity<String> login(@RequestBody Map<String, String> payload, HttpServletRequest request) {
     String username = payload.get("username");
     String password = payload.get("password");

     System.out.println("Received username: " + username + ", password: " + password);

     Manager m = msi.Login(username, password);

     if (m != null) {
         return ResponseEntity.ok("登入成功");
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("使用者或密碼錯誤");
     }
 }
*/
		
@PostMapping("/login")//Post 傳輸大量資料
public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password,HttpServletRequest request) {
	
	 String rul=request.getRemoteHost();
	 
	Manager m=msi.Login(username, password);
	
	

	if(m!=null) {
		
		
		return ResponseEntity.ok(m.getUsername());
		
	}else {
		return ResponseEntity.status(401).body("使用者或密碼錯誤");
	}
	
}


 @DeleteMapping("/delete")
    public String deleteManager(@RequestParam String username,HttpServletRequest request) {
        
	 String rul=request.getRemoteHost();
	 Integer id = msi.findIdByUsername(username);
        if (id != null) {
            msi.deleteById(id);
            return "已刪除使用者：" + username;
        } else {
            return "刪除失敗：找不到使用者名稱 " + username;
            
        }
    }
}
