package com.spring.content.controller;

import com.spring.content.common.ResponseResult;
import com.spring.content.common.ResultCode;
import com.spring.content.domain.dto.ShareDto;
import com.spring.content.domain.entity.Share;
import com.spring.content.domain.entity.User;
import com.spring.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * @description:
 * @author: mqxu
 * @date: 2022-09-06
 **/
@RestController
@Slf4j
@RequestMapping(value = "/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;

    private final RestTemplate restTemplate;

    private final String SERVICE_URL = "http://user-service";


    /**
     * 使用 restTemplate 调用下级服务
     *
     * @return User
     */
    @GetMapping("{id}")
    public ResponseResult getShareById(@PathVariable Integer id) {
        Share share = shareService.findById(id);
        if (share != null) {
            // 获得用户id
            Integer userId = share.getUserId();
            // 访问用户服务
            User user = restTemplate.getForObject(SERVICE_URL + "/users/" + userId, User.class);
            ShareDto shareDto = null;
            if (user != null) {
                // 拼装返回数据
                shareDto = ShareDto.builder().share(share).nickName(user.getNickname()).avatar(user.getAvatar()).build();
            }
            return ResponseResult.success(shareDto);
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}