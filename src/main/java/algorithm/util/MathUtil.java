/*
 * Copyright (c) 2012 Caitsithx - All rights reserved.
 *
 * $Revison$
 * $author$
 */
package algorithm.util;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 */
public class MathUtil {
   private static Long[][] MASKS = null;
   
   public final static long getDigit(long p_input, int p_radius, int p_index) {
	int l_expDictLen = p_radius + 1;
	if(MASKS == null) {
	   MASKS = new Long[l_expDictLen][];
	}

	if(MASKS.length < l_expDictLen) {
	   Long[][] l_tmp = new Long[l_expDictLen][];
	   System.arraycopy(MASKS, 0, l_tmp, 0, MASKS.length);
	   MASKS = l_tmp;
	}

	int l_expItemLen = p_index + 1;
	if(MASKS[p_radius] == null) {
	   MASKS[p_radius] = new Long[l_expItemLen];
	}
	
	if(MASKS[p_radius].length < l_expItemLen) {
	   Long[] l_tmp = new Long[l_expItemLen];
	   System.arraycopy(MASKS[p_radius], 0, l_tmp, 0, MASKS[p_radius].length);
	   MASKS[p_radius] = l_tmp;
	}

	if(MASKS[p_radius][p_index] == null) {
	   MASKS[p_radius][p_index] = Long.valueOf((long)Math.pow(p_radius, p_index));
	}
	
	if(MASKS[p_radius][p_index - 1] == null) {
	   MASKS[p_radius][p_index - 1] = Long.valueOf((long)Math.pow(p_radius, p_index - 1));
	}
	
	return (p_input / MASKS[p_radius][p_index - 1]) - (p_input / MASKS[p_radius][p_index] * p_radius);
   }
   
   @Test
   public void case1() {
	Assert.assertEquals(4, MathUtil.getDigit(1234, 10, 1));
	Assert.assertEquals(3, MathUtil.getDigit(1234, 10, 2));
	Assert.assertEquals(2, MathUtil.getDigit(1234, 10, 3));
	Assert.assertEquals(1, MathUtil.getDigit(1234, 10, 4));
	Assert.assertEquals(0, MathUtil.getDigit(1234, 10, 5));
	Assert.assertEquals(0, MathUtil.getDigit(1234, 10, 6));
	
	Assert.assertEquals(1, MathUtil.getDigit(0x11, 2, 1));
	Assert.assertEquals(0, MathUtil.getDigit(0x11, 2, 2));
	Assert.assertEquals(0, MathUtil.getDigit(0x11, 2, 3));
	Assert.assertEquals(0, MathUtil.getDigit(0x11, 2, 4));
	Assert.assertEquals(1, MathUtil.getDigit(0x11, 2, 5));
	Assert.assertEquals(0, MathUtil.getDigit(0x11, 2, 6));
   }
}
