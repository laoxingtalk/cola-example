package com.github.laoxingtalk.cola.example.command;

import com.alibaba.cola.dto.Response;
import com.github.laoxingtalk.cola.example.convertor.UserProfileConvertor;
import com.github.laoxingtalk.cola.example.domain.user.UserProfile;
import com.github.laoxingtalk.cola.example.dto.UserProfileAddCmd;
import com.github.laoxingtalk.cola.example.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.create(userProfile);
        return Response.buildSuccess();
    }
}
