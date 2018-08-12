/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm.puzzle100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 */
public class N007_Ext_RingRace {

    public int[] whenWeMeet(int p_ringLen, int p_largePace, int p_smallPace2) {
        int[] l_yes = new int[p_ringLen];
        int val = -1;
        int l_i = 1;
        int l_i2 = 0;
        int l_paceDiff = p_largePace - p_smallPace2;

        for (int l_time = 1; l_i2 < l_yes.length; l_time++) {
            if (((l_paceDiff * l_time) % p_ringLen) == 0) {
                l_yes[l_i2] = l_time;
                l_i2++;
            }
        }

        return l_yes;
    }

    @Test
    public void case1() {
        N007_Ext_RingRace l_race = new N007_Ext_RingRace();
        int[] l_res = null;
        l_res = l_race.whenWeMeet(4, 1, 1);
        System.out.println(Arrays.toString(l_res));

        l_res = l_race.whenWeMeet(4, 1, 5);
        System.out.println(Arrays.toString(l_res));

        l_res = l_race.whenWeMeet(4, 1, 2);
        System.out.println(Arrays.toString(l_res));

        l_res = l_race.whenWeMeet(4, 2, 3);
        System.out.println(Arrays.toString(l_res));

        l_res = l_race.whenWeMeet(4, 3, 4);
        System.out.println(Arrays.toString(l_res));

        l_res = l_race.whenWeMeet(4, 1, 4);
        System.out.println(Arrays.toString(l_res));

        l_res = l_race.whenWeMeet(4, 2, 5);
        System.out.println(Arrays.toString(l_res));

        l_res = l_race.whenWeMeet(4, 1, 3);
        System.out.println(Arrays.toString(l_res));
    }
}
