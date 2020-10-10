package com.ruoyi.common.message;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 阿里云短信验证码
 */
public class shortMessage {
    //对应accessKeyId
    private static  final  String accessKeyId="LTAI4FbeF2m6M54D4nAxNpbp";
    //对应accessKeySercret
    private static  final  String accessKeySercret="F0uJOmpI35PGRj44YT3HUjBh7IMsmP";
    //对应签名名称
    private static  final  String signname="漕河泾项目";
    //对应模板代码
    private static  final  String templateCode="SMS_186380267";
   //对应发送的验证码
//    private static int moblie_code=(int)((Math.random()*9+1)*100000);
    private static int moblie_code = 46884;

    /**
     * 短信发送
     */
    public static void SendMsg(String telphone){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySercret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        //aliyun对应发送短信的服务器地址
        request.setDomain("dysmsapi.aliyuncs.com");
        //对应版本号
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telphone);
        request.putQueryParameter("SignName", signname);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"ylplove\":"+moblie_code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());//返回信息
            System.out.println(moblie_code);//返回验证码，可将验证码和手机号存入rides中，并设置多长时间过期
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        shortMessage.SendMsg("17789615595");
    }
}