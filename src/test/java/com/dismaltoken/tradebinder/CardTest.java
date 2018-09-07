package com.dismaltoken.tradebinder;

import org.testng.annotations.Test;

public class CardTest {
    @Test
    public void cardTest1() {
        final Name name = null; //new Name();
        final MTGSet set = MTGSet.AETHER_REVOLT;
        final Language language =Language.ENGLISH;
        final boolean isFoil = false;
        Card card = new Card(name, set, language, isFoil);
    }
}
