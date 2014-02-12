package cz.mrq.experiments;

import cz.mrq.experiments.util.Time;

import java.util.UUID;

/**
 * KeyDistribution
 *
 * @author Lumir Mrkva (lumir.mrkva@topmonks.com)
 */
public class KeyDistribution {

    @Time
    public static void uuid() {
        int cnt = 0;
        UUID uuid = UUID.randomUUID();
        String prefix = getPrefix(uuid);
        System.out.println(uuid);
        System.out.println(prefix);
        while (cnt < Integer.MAX_VALUE) {
            UUID newId = UUID.randomUUID();
            if (prefix.equals(getPrefix(newId))) {
                System.out.println("After "+cnt+ "iterations found same prefix :" + newId);
                cnt = 0;
            }
            cnt++;
        }
    }

    private static String getPrefix(UUID uuid) {
        String id = uuid.toString();
        return id.substring(0,id.indexOf('-'));
    }
}
