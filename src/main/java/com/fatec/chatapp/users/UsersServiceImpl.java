package com.fatec.chatapp.users;

import com.fatec.chatapp.activities.ActivityModel;
import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import com.fatec.chatapp.roles.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserModel create(UserModel user) {
        return usersRepository.save(user);
    }

    @Override
    public UserModel findOneById(UUID id) {
        return usersRepository.findOneById(id);
    }

    @Override
    public List<UserModel> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public UserModel findOneByEmail(String e) {
        return usersRepository.findOneByEmail(e);
    }

    @Override
    public UserModel updateById(UUID id, UserModel u) {
        final UserModel model = usersRepository.findOneById(id);
        if (u.getName() != null) {
            model.setName(u.getName());
        }

        if (u.getEmail() != null) {
            model.setEmail(u.getEmail());
        }

        if (u.getActivities() != null && u.getActivities().size() > 0) {
            for (ActivityModel activity : u.getActivities()){
                model.getActivities().add(activity);
            }
        }

        if (u.getChats() != null && u.getChats().size() > 0) {
            for (ChatModel chat : u.getChats()){
                model.getChats().add(chat);
            }
        }

        return usersRepository.save(model);
    }

    @Override
    public UserModel addChat(UserModel u, ChatModel c) {
        u.getChats().add(c);
        return usersRepository.save(u);
    }

    @Override
    public UserModel addRole(UserModel u, RoleModel r) {
        u.getRoles().add(r);
        return usersRepository.save(u);
    }
}
