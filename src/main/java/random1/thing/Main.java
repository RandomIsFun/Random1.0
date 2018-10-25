package random1.thing;

import lombok.Getter;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;

import javax.security.auth.login.LoginException;

/**
 * ------------------------------
 * Copyright (c) AndrewAubury 2018
 * https://www.andrewa.pw
 * Project: random1
 * ------------------------------
 */
public class Main {
    @Getter public static JDA jda;

    private void setupJDA(String token) throws LoginException {
        jda = new JDABuilder().setToken(token).setGame(Game.playing("Random1.0")).build();

        for(Guild g :jda.getGuilds()){
            try {
                g.getDefaultChannel().sendMessage("Started!").queue();
            }
            catch(NullPointerException e){
                e.printStackTrace();
            }
        }
    }


}
