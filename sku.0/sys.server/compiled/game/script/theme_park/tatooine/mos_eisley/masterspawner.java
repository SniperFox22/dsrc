package script.theme_park.tatooine.mos_eisley;

import script.*;
import script.base_class.*;
import script.combat_engine.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;
import script.base_script;

import script.library.create;
import script.library.ai_lib;
import script.library.performance;

public class masterspawner extends script.base_script
{
    public masterspawner()
    {
    }
    public int OnInitialize(obj_id self) throws InterruptedException
    {
        debugServerConsoleMsg(self, "Initialized Mos Eisley Cantina spawner script");
        dictionary params = new dictionary();
        messageTo(self, "spawnThings", null, 2, true);
        return SCRIPT_CONTINUE;
    }
    public void spawnEveryone(obj_id self) throws InterruptedException
    {
        spawnPadawanTrialsNpc(self);
        spawnBarPatronsRight(self);
        spawnWuher(self);
        spawnSittingPatrons(self);
        spawnBithBand(self);
        spawnAudience(self);
        spawnStandingConvoGroup(self);
        spawnClosePatrons(self);
        spawnFoyer(self);
        spawnChadraFans(self);
        spawnCheatedGambler(self);
        spawnEntAlcove(self);
        spawnJunkDealer(self);
        return;
    }
    public void spawnHanandChewie(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location han_loc = new location(10.50f, 1.0f, 11.98f, "tatooine", room);
        int han_yaw = -177;
        location chewie_loc = new location(10.22f, 1.0f, 9.78f, "tatooine", room);
        int chewie_yaw = 0;
        obj_id han = create.object("han_solo", han_loc);
        obj_id chewie = create.object("chewbacca", chewie_loc);
        setYaw(han, han_yaw);
        setYaw(chewie, chewie_yaw);
        setInvulnerable(han, true);
        setInvulnerable(chewie, true);
        setCreatureStatic(han, true);
        setCreatureStatic(chewie, true);
        return;
    }
    public void spawnPadawanTrialsNpc(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location npc_loc = new location(-9.34f, 1.0f, 5.66f, "tatooine", room);
        int npc_yaw = 105;
        obj_id npc = create.object("patron_human_male_01", npc_loc);
        setYaw(npc, npc_yaw);
        setInvulnerable(npc, true);
        setCreatureStatic(npc, true);
        ai_lib.setDefaultCalmMood(npc, "npc_standing_drinking");
        obj_id cup = createObject("object/tangible/item/con_drinking_glass_01.iff", npc, "");
        equip(cup, npc);
        setName(npc, "Marco Vahn (a booking agent)");
        attachScript(npc, "conversation.padawan_old_musician_02");
        setObjVar(self, "cantinaInhabitants.padawanTrialsNpc", npc);
        return;
    }
    public void spawnChadraFans(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location c1_loc = new location(10.70f, 1.0f, -0.23f, "tatooine", room);
        int c1_yaw = -158;
        location c2_loc = new location(10.43f, 1.0f, -1.47f, "tatooine", room);
        int c2_yaw = 25;
        obj_id c1 = create.object("chadra_fan_male", c1_loc);
        obj_id c2 = create.object("chadra_fan_female", c2_loc);
        setYaw(c1, c1_yaw);
        setYaw(c2, c2_yaw);
        setCreatureStatic(c1, true);
        setCreatureStatic(c2, true);
        setInvulnerable(c1, true);
        setInvulnerable(c2, true);
        ai_lib.setDefaultCalmMood(c1, "conversation");
        ai_lib.setDefaultCalmMood(c2, "conversation");
        return;
    }
    public void spawnFoyer(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "foyer2");
        location f1_loc = new location(29.51f, 1.0f, -7.38f, "tatooine", room);
        int f1_yaw = 47;
        location f2_loc = new location(31.01f, 1.0f, -8.83f, "tatooine", room);
        int f2_yaw = -12;
        location f3_loc = new location(29.54f, 1.0f, -6.18f, "tatooine", room);
        int f3_yaw = 171;
        location f4_loc = new location(35.96f, 1.0f, 0.74f, "tatooine", room);
        int f4_yaw = 1;
        location f5_loc = new location(35.72f, 1.0f, 3.19f, "tatooine", room);
        int f5_yaw = 158;
        location f6_loc = new location(31.6f, 0.1f, 0.3f, "tatooine", room);
        int f6_yaw = -90;
        obj_id f1 = create.object("commoner", f1_loc);
        obj_id f2 = create.object("commoner", f2_loc);
        obj_id f3 = create.object("commoner", f3_loc);
        obj_id f4 = create.object("commoner", f4_loc);
        obj_id f5 = create.object("commoner", f5_loc);
        obj_id f6 = create.object("newbie_tutorial_entertainer", f6_loc);
        setYaw(f1, f1_yaw);
        setYaw(f2, f2_yaw);
        setYaw(f3, f3_yaw);
        setYaw(f4, f4_yaw);
        setYaw(f5, f5_yaw);
        setYaw(f6, f6_yaw);
        setCreatureStatic(f1, true);
        setInvulnerable(f1, true);
        setCreatureStatic(f2, true);
        setInvulnerable(f2, true);
        setCreatureStatic(f3, true);
        setInvulnerable(f3, true);
        setCreatureStatic(f4, true);
        setInvulnerable(f4, true);
        setCreatureStatic(f5, true);
        setInvulnerable(f5, true);
        setCreatureStatic(f6, true);
        setInvulnerable(f6, true);
        ai_lib.setDefaultCalmMood(f1, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(f2, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(f3, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(f4, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(f5, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(f6, "npc_imperial");
        attachScript(f6, "conversation.c_newbie_entertainer");
        return;
    }
    public void spawnClosePatrons(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location s1_loc = new location(22.31f, 1.0f, 3.00f, "tatooine", room);
        int s1_yaw = -19;
        location s2_loc = new location(20.52f, 1.0f, 4.10f, "tatooine", room);
        int s2_yaw = 73;
        location s3_loc = new location(21.19f, 1.0f, 5.65f, "tatooine", room);
        int s3_yaw = 157;
        location s4_loc = new location(23.37f, 1.0f, 4.88f, "tatooine", room);
        int s4_yaw = -103;
        location s5_loc = new location(16.96f, 1.0f, 6.62f, "tatooine", room);
        int s5_yaw = -114;
        location s6_loc = new location(14.97f, 1.0f, 6.77f, "tatooine", room);
        int s6_yaw = 88;
        obj_id s1 = create.object("patron_ishitib_male", s1_loc);
        obj_id s2 = create.object("muftak", s2_loc);
        obj_id s3 = create.object("patron_devaronian_male", s3_loc);
        obj_id s4 = create.object("patron_nikto", s4_loc);
        obj_id s5 = create.object("patron_quarren", s5_loc);
        obj_id s6 = create.object("patron_klaatu", s6_loc);
        setYaw(s1, s1_yaw);
        setYaw(s2, s2_yaw);
        setYaw(s3, s3_yaw);
        setYaw(s4, s4_yaw);
        setYaw(s5, s5_yaw);
        setYaw(s6, s6_yaw);
        setCreatureStatic(s1, true);
        setCreatureStatic(s2, true);
        setCreatureStatic(s3, true);
        setCreatureStatic(s4, true);
        setCreatureStatic(s5, true);
        setCreatureStatic(s6, true);
        setInvulnerable(s1, true);
        setInvulnerable(s2, true);
        setInvulnerable(s3, true);
        setInvulnerable(s4, true);
        setInvulnerable(s5, true);
        setInvulnerable(s6, true);
        ai_lib.setDefaultCalmMood(s1, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(s2, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(s3, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(s4, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(s5, "npc_sitting_chair");
        ai_lib.setDefaultCalmMood(s6, "npc_sitting_chair");
        return;
    }
    public void spawnStandingConvoGroup(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location itho_loc = new location(15.89f, 1.0f, 2.48f, "tatooine", room);
        int itho_yaw = 36;
        location greeata_loc = new location(16.46f, 1.0f, 2.98f, "tatooine", room);
        int greeata_yaw = -129;
        obj_id itho = create.object("patron_ithorian_male", itho_loc);
        obj_id greeata = create.object("commoner", greeata_loc);
        setYaw(itho, itho_yaw);
        setYaw(greeata, greeata_yaw);
        setCreatureStatic(itho, true);
        setCreatureStatic(greeata, true);
        setInvulnerable(itho, true);
        setInvulnerable(greeata, true);
        ai_lib.setDefaultCalmMood(itho, "nervous");
        ai_lib.setDefaultCalmMood(greeata, "conversation");
        return;
    }
    public void spawnAudience(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location a1_loc = new location(8.68f, 1.0f, -6.08f, "tatooine", room);
        int a1_yaw = -148;
        location a2_loc = new location(6.76f, 1.0f, -6.48f, "tatooine", room);
        int a2_yaw = 177;
        location a3_loc = new location(1.99f, 1.0f, -8.44f, "tatooine", room);
        int a3_yaw = -35;
        location a4_loc = new location(1.19f, 1.0f, -7.63f, "tatooine", room);
        int a4_yaw = 152;
        location a5_loc = new location(3.62f, 1.0f, -6.78f, "tatooine", room);
        int a5_yaw = 0;
        location a6_loc = new location(2.84f, 1.0f, -6.30f, "tatooine", room);
        int a6_yaw = 16;
        location a7_loc = new location(3.62f, 1.0f, -4.77f, "tatooine", room);
        int a7_yaw = -176;
        location a8_loc = new location(1.74f, 1.0f, -4.91f, "tatooine", room);
        int a8_yaw = 95;
        obj_id a1 = create.object("patron_human_female_01", a1_loc);
        obj_id a2 = create.object("patron_human_male_01", a2_loc);
        obj_id a3 = create.object("commoner", a3_loc);
        obj_id a4 = create.object("commoner", a4_loc);
        obj_id a5 = create.object("stormtrooper_squad_leader", a5_loc);
        obj_id a6 = create.object("stormtrooper", a6_loc);
        obj_id a7 = create.object("patron_chiss_female", a7_loc);
        obj_id a8 = create.object("patron_chiss_male", a8_loc);
        setYaw(a1, a1_yaw);
        setYaw(a2, a2_yaw);
        setYaw(a3, a3_yaw);
        setYaw(a4, a4_yaw);
        setYaw(a5, a5_yaw);
        setYaw(a6, a6_yaw);
        setYaw(a7, a7_yaw);
        setYaw(a8, a8_yaw);
        setCreatureStatic(a1, true);
        setCreatureStatic(a2, true);
        setCreatureStatic(a3, true);
        setCreatureStatic(a4, true);
        setCreatureStatic(a5, true);
        setCreatureStatic(a6, true);
        setCreatureStatic(a7, true);
        setCreatureStatic(a8, true);
        setInvulnerable(a1, true);
        setInvulnerable(a2, true);
        setInvulnerable(a3, true);
        setInvulnerable(a4, true);
        setInvulnerable(a5, true);
        setInvulnerable(a6, true);
        setInvulnerable(a7, true);
        setInvulnerable(a8, true);
        ai_lib.setDefaultCalmMood(a1, "entertained");
        ai_lib.setDefaultCalmMood(a2, "entertained");
        ai_lib.setDefaultCalmMood(a3, "conversation");
        ai_lib.setDefaultCalmMood(a4, "conversation");
        ai_lib.setDefaultCalmMood(a5, "npc_accusing");
        ai_lib.setDefaultCalmMood(a6, "npc_imperial");
        ai_lib.setDefaultCalmMood(a7, "npc_sad");
        ai_lib.setDefaultCalmMood(a8, "npc_consoling");
        return;
    }
    public void spawnBarPatronsRight(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location p1_loc = new location(10.65f, 1.0f, 1.91f, "tatooine", room);
        location p2_loc = new location(10.17f, 1.0f, 2.74f, "tatooine", room);
        location p3_loc = new location(9.08f, 1.0f, 4.15f, "tatooine", room);
        location p4_loc = new location(8.49f, 1.0f, 4.64f, "tatooine", room);
        location p5_loc = new location(6.11f, 1.0f, 5.40f, "tatooine", room);
        location p6_loc = new location(5.11f, 1.0f, 5.40f, "tatooine", room);
        location p7_loc = new location(4.11f, 1.0f, 5.40f, "tatooine", room);
        location p8_loc = new location(3.11f, 1.0f, 5.40f, "tatooine", room);
        location p9_loc = new location(2.11f, 1.0f, 5.40f, "tatooine", room);
        location p10_loc = new location(1.11f, 1.0f, 5.40f, "tatooine", room);
        location p11_loc = new location(-1.11f, 1.0f, 5.40f, "tatooine", room);
        location p12_loc = new location(-2.11f, 1.0f, 6.40f, "tatooine", room);
        location p13_loc = new location(-3.11f, 1.0f, 5.40f, "tatooine", room);
        location p14_loc = new location(-4.11f, 1.0f, 5.40f, "tatooine", room);
        location p15_loc = new location(-5.11f, 1.0f, 6.40f, "tatooine", room);
        location p16_loc = new location(-6.11f, 1.0f, 5.40f, "tatooine", room);
        obj_id p1 = create.object("businessman", p1_loc);
        obj_id p2 = create.object("commoner", p2_loc);
        obj_id p3 = create.object("entertainer", p3_loc);
        obj_id p4 = create.object("noble", p4_loc);
        obj_id p7 = create.object("commoner", p7_loc);
        obj_id p8 = create.object("commoner", p8_loc);
        obj_id p9 = create.object("commoner", p9_loc);
        obj_id p10 = create.object("commoner", p10_loc);
        obj_id p13 = create.object("commoner", p13_loc);
        obj_id p14 = create.object("businessman", p14_loc);
        setCreatureStatic(p1, true);
        setCreatureStatic(p2, true);
        setCreatureStatic(p3, true);
        setCreatureStatic(p4, true);
        setCreatureStatic(p7, true);
        setCreatureStatic(p8, true);
        setCreatureStatic(p9, true);
        setCreatureStatic(p10, true);
        setCreatureStatic(p13, true);
        setCreatureStatic(p14, true);
        setInvulnerable(p1, true);
        setInvulnerable(p2, true);
        setInvulnerable(p3, true);
        setInvulnerable(p4, true);
        setInvulnerable(p7, true);
        setInvulnerable(p8, true);
        setInvulnerable(p9, true);
        setInvulnerable(p10, true);
        setInvulnerable(p13, true);
        setInvulnerable(p14, true);
        setYaw(p1, -82);
        setYaw(p2, -133);
        setYaw(p3, -92);
        setYaw(p4, 159);
        setYaw(p8, 161);
        setYaw(p10, 155);
        setYaw(p13, 105);
        setYaw(p14, -106);
        ai_lib.setDefaultCalmMood(p1, "npc_standing_drinking");
        ai_lib.setDefaultCalmMood(p2, "conversation");
        ai_lib.setDefaultCalmMood(p3, "npc_standing_drinking");
        ai_lib.setDefaultCalmMood(p4, "conversation");
        ai_lib.setDefaultCalmMood(p7, "npc_standing_drinking");
        ai_lib.setDefaultCalmMood(p8, "npc_standing_drinking");
        ai_lib.setDefaultCalmMood(p9, "conversation");
        ai_lib.setDefaultCalmMood(p10, "npc_standing_drinking");
        ai_lib.setDefaultCalmMood(p13, "npc_standing_drinking");
        ai_lib.setDefaultCalmMood(p14, "npc_standing_drinking");
        obj_id cup1 = createObject("object/tangible/item/con_drinking_glass_01.iff", p1, "");
        equip(cup1, p1);
        obj_id cup3 = createObject("object/tangible/item/con_drinking_glass_01.iff", p3, "");
        equip(cup3, p3);
        obj_id cup7 = createObject("object/tangible/item/con_drinking_glass_01.iff", p7, "");
        equip(cup7, p7);
        obj_id cup8 = createObject("object/tangible/item/con_drinking_glass_01.iff", p8, "");
        equip(cup8, p8);
        obj_id cup10 = createObject("object/tangible/item/con_drinking_glass_01.iff", p10, "");
        equip(cup10, p10);
        obj_id cup13 = createObject("object/tangible/item/con_drinking_glass_01.iff", p13, "");
        equip(cup13, p13);
        obj_id cup14 = createObject("object/tangible/item/con_drinking_glass_01.iff", p14, "");
        equip(cup14, p14);
        return;
    }
    public void spawnSittingPatrons(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location p1_loc = new location(16.37f, 1.0f, -3.23f, "tatooine", room);
        int p1_yaw = -128;
        location p2_loc = new location(14.57f, 1.0f, -2.85f, "tatooine", room);
        int p2_yaw = 127;
        location p3_loc = new location(14.21f, 1.0f, -4.89f, "tatooine", room);
        int p3_yaw = 46;
        location p4_loc = new location(16.49f, 1.0f, -4.86f, "tatooine", room);
        int p4_yaw = -48;
        obj_id p2 = create.object("patron_human_female_02", p2_loc);
        obj_id p3 = create.object("patron_human_male_03", p3_loc);
        obj_id p4 = create.object("patron_human_female_03", p4_loc);
        setCreatureStatic(p2, true);
        setCreatureStatic(p3, true);
        setCreatureStatic(p4, true);
        setInvulnerable(p2, true);
        setInvulnerable(p3, true);
        setInvulnerable(p4, true);
        setYaw(p2, p2_yaw);
        setYaw(p3, p3_yaw);
        setYaw(p4, p4_yaw);
        ai_lib.setDefaultCalmMood(p2, "npc_sitting_table");
        ai_lib.setDefaultCalmMood(p3, "npc_sitting_table_eating");
        ai_lib.setDefaultCalmMood(p4, "npc_sitting_chair");
        location p7_loc = new location(24.34f, 1.0f, -8.23f, "tatooine", room);
        int p7_yaw = 49;
        location p8_loc = new location(26.20f, 1.0f, -8.33f, "tatooine", room);
        int p8_yaw = -43;
        obj_id p7 = create.object("patron_human_female_04", p7_loc);
        obj_id p8 = create.object("patron_human_male_04", p8_loc);
        setCreatureStatic(p7, true);
        setCreatureStatic(p8, true);
        setInvulnerable(p7, true);
        setInvulnerable(p8, true);
        setYaw(p7, p7_yaw);
        setYaw(p8, p8_yaw);
        ai_lib.setDefaultCalmMood(p7, "npc_sitting_table_eating");
        ai_lib.setDefaultCalmMood(p8, "npc_sitting_chair");
        return;
    }
    public void spawnWuher(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "cantina");
        location wuherLoc = new location(8.46f, 1.0f, 0.35f, "tatooine", room);
        obj_id wuher = create.object("wuher", wuherLoc);
        create.addDestroyMessage(wuher, "wuherDied", 10f, self);
        setCreatureStatic(wuher, true);
        setInvulnerable(wuher, true);
        setYaw(wuher, 47);
        ai_lib.setDefaultCalmMood(wuher, "npc_imperial");
        attachScript(wuher, "npc.bartender.base");
        attachScript(wuher, "npc.bartender.listen");
        return;
    }
    public void spawnBithBand(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "alcove3");
        location figrinloc = new location(3.69f, 1.0f, -14.40f, "tatooine", room);
        int figrinYaw = 50;
        location boxloc = new location(4.11f, 1.0f, -17.07f, "tatooine", room);
        int boxYaw = 45;
        location hornloc = new location(1.29f, 1.0f, -15.18f, "tatooine", room);
        int hornYaw = 70;
        location fizzloc = new location(2.32f, 1.0f, -16.47f, "tatooine", room);
        int fizzYaw = 44;
        location bfloc = new location(0.54f, 1.0f, -17.13f, "tatooine", room);
        int bfYaw = 38;
        obj_id figrin = create.object("figrin_dan", figrinloc);
        obj_id box = create.object("bith_musician", boxloc);
        obj_id horn = create.object("bith_musician", hornloc);
        obj_id fizz = create.object("bith_musician", fizzloc);
        obj_id bandfill = create.object("bith_musician", bfloc);
        setObjVar(figrin, performance.NPC_ENTERTAINMENT_NO_ENTERTAIN, 1);
        setObjVar(box, performance.NPC_ENTERTAINMENT_NO_ENTERTAIN, 1);
        setObjVar(horn, performance.NPC_ENTERTAINMENT_NO_ENTERTAIN, 1);
        setObjVar(fizz, performance.NPC_ENTERTAINMENT_NO_ENTERTAIN, 1);
        setObjVar(bandfill, performance.NPC_ENTERTAINMENT_NO_ENTERTAIN, 1);
        ai_lib.setDefaultCalmMood(figrin, "themepark_music_3");
        ai_lib.setDefaultCalmMood(box, "themepark_music_2");
        ai_lib.setDefaultCalmMood(horn, "themepark_music_3");
        ai_lib.setDefaultCalmMood(fizz, "themepark_music_3");
        ai_lib.setDefaultCalmMood(bandfill, "themepark_music_3");
        setYaw(figrin, figrinYaw);
        setYaw(box, boxYaw);
        setYaw(horn, hornYaw);
        setYaw(fizz, fizzYaw);
        setYaw(bandfill, bfYaw);
        setCreatureStatic(figrin, true);
        setInvulnerable(figrin, true);
        setCreatureStatic(box, true);
        setInvulnerable(box, true);
        setCreatureStatic(horn, true);
        setInvulnerable(horn, true);
        setCreatureStatic(fizz, true);
        setInvulnerable(fizz, true);
        setCreatureStatic(bandfill, true);
        setInvulnerable(bandfill, true);
        setName(figrin, "Figrin D'an");
        setName(box, "Tech Mo'r");
        setName(horn, "Tedn Dahai");
        setName(fizz, "Doikk Na'ts");
        setName(bandfill, "Nalan Cheel");
        obj_id kloo = createObject("object/tangible/instrument/kloo_horn.iff", figrin, "");
        equip(kloo, figrin);
        obj_id kloo2 = createObject("object/tangible/instrument/kloo_horn.iff", horn, "");
        equip(kloo2, horn);
        obj_id fizzHorn = createObject("object/tangible/instrument/fizz.iff", fizz, "");
        equip(fizzHorn, fizz);
        obj_id bf = createObject("object/tangible/instrument/bandfill.iff", bandfill, "");
        equip(bf, bandfill);
        return;
    }
    public int spawnThings(obj_id self, dictionary params) throws InterruptedException
    {
        spawnEveryone(self);
        return SCRIPT_CONTINUE;
    }
    public int peopleDied(obj_id self, dictionary params) throws InterruptedException
    {
        spawnEveryone(self);
        return SCRIPT_CONTINUE;
    }
    public int wuherDied(obj_id self, dictionary params) throws InterruptedException
    {
        spawnWuher(self);
        return SCRIPT_CONTINUE;
    }
    public int OnHearSpeech(obj_id self, obj_id speaker, String text) throws InterruptedException
    {
        if (!hasObjVar(speaker, "gm_testing"))
        {
            return SCRIPT_CONTINUE;
        }
        if (text.equals("padawan_trials"))
        {
            spawnPadawanTrialsNpc(self);
        }
        if (text.equals("kill_padawan"))
        {
            obj_id npc = getObjIdObjVar(self, "cantinaInhabitants.padawanTrialsNpc");
            if (isIdValid(npc))
            {
                destroyObject(npc);
            }
        }
        return SCRIPT_CONTINUE;
    }
    public void spawnCheatedGambler(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "stage");
        location CG = new location(-6.5f, -.9f, -20.7f, "tatooine", room);
        int yaw = 60;
        obj_id gambler = create.object("ep3_cheated_gambler", CG);
        setYaw(gambler, yaw);
        ai_lib.setDefaultCalmMood(gambler, "npc_sad");
        return;
    }
    public void spawnEntAlcove(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "alcove1");
        location entLoc = new location(19.5f, -.9f, -19.8f, "tatooine", room);
        int yaw = -1;
        obj_id ent = create.object("prof_quest_entertainer", entLoc);
        setYaw(ent, yaw);
        setCreatureStatic(ent, true);
        setInvulnerable(ent, true);
        ai_lib.setDefaultCalmMood(ent, "npc_imperial");
        attachScript(ent, "conversation.c_prof_ent_questgiver");
        return;
    }
    public void spawnJunkDealer(obj_id self) throws InterruptedException
    {
        obj_id room = getCellId(self, "private_room2");
        location junkLoc = new location(-30.9152f, -0.52f, 6.8631f, "tatooine", room);
        int yaw = 25;
        obj_id junkDealer = create.object("junk_dealer", junkLoc);
        setYaw(junkDealer, yaw);
        setInvulnerable(junkDealer, true);
        ai_lib.setDefaultCalmMood(junkDealer, "npc_imperial");
        return;
    }
}