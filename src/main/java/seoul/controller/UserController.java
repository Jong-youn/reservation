package seoul.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seoul.controller.request.UserSignUpReq;
import seoul.mapper.UserMapper;
import seoul.service.UserService;
import seoul.service.dto.UserDto;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @PostMapping
    public String signUp(@RequestBody UserSignUpReq request) {
        request.setCreatedAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")));

        UserDto userDto = mapper.toDto(request);
        service.signUp(userDto);
        return "성공";
    }
}
