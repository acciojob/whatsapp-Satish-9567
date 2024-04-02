package com.driver;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class WhatsappService {
    private WhatsappRepository whatsappRepository=new WhatsappRepository();

    public String createUser(String name,String number) throws Exception
    {
        if(whatsappRepository.findUserByPhone(number))
        {
            throw new Exception("User already exists");
        }
        return whatsappRepository.addUser(name,number);
    }
    public Group createGroup(List<User> userList)
    {
        return  whatsappRepository.addGroup(userList);
    }
    public int createMessage(String content)
    {
        return whatsappRepository.createMessage(content);
    }
    public int sendMessage(Message message,User sender,Group group) throws Exception
    {
       return  whatsappRepository.sendMessage(message,sender,group);
    }
    public String  changeAdmin(User approver, User user, Group group) throws Exception
    {
        return whatsappRepository.changeAdmin(approver,user,group);
    }
    public  int removeUser(User user) throws Exception
    {
        return whatsappRepository.removeUser(user);
    }
    public String findMessage(Date start, Date end, int k) throws Exception {
        return whatsappRepository.findMessage(start,end,k);
    }
    /* <-----------------------------DONE----------------------------------> */

}
