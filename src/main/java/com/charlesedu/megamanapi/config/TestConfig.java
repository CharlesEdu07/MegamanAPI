package com.charlesedu.megamanapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.charlesedu.megamanapi.entities.RobotMaster;
import com.charlesedu.megamanapi.repositories.IRobotMasterRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

        @Autowired
        private IRobotMasterRepository robotMasterRepository;

        @Override
        public void run(String... args) throws Exception {
                RobotMaster robotMaster1 = new RobotMaster(null, "2", "009", "Metal Man", "Metal Blade",
                                "http://vignette1.wikia.nocookie.net/megaman/images/6/69/Metalmugshot.png",
                                "http://vignette4.wikia.nocookie.net/megaman/images/e/e3/Metalsprite.png",
                                "Quick Boomerang/Metal Blade");

                RobotMaster robotMaster2 = new RobotMaster(null, "2", "010", "Air Man", "Air Blade",
                                "http://vignette1.wikia.nocookie.net/megaman/images/a/af/Airmugshot.png",
                                "http://vignette4.wikia.nocookie.net/megaman/images/3/37/Airsprite.png",
                                "Leaf Shield");

                RobotMaster robotMaster3 = new RobotMaster(null, "2", "011", "Bubble Man", "Bubble Lead",
                                "http://vignette4.wikia.nocookie.net/megaman/images/5/53/Bubblemugshot.png",
                                "http://vignette3.wikia.nocookie.net/megaman/images/d/d2/Bubblesprite.png",
                                "Metal Blade");

                RobotMaster robotMaster4 = new RobotMaster(null, "2", "012", "Quick Man", "Quick Boomerang",
                                "http://vignette1.wikia.nocookie.net/megaman/images/1/1a/Quickmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/e/e6/Quicksprite.png",
                                "Time Stopper/Crash Bomber");

                RobotMaster robotMaster5 = new RobotMaster(null, "2", "013", "Crash Man", "Crash Bomber",
                                "http://vignette4.wikia.nocookie.net/megaman/images/4/47/Crashmugshot.png",
                                "http://vignette1.wikia.nocookie.net/megaman/images/7/79/Crashsprite.png",
                                "Air Shooter");

                RobotMaster robotMaster6 = new RobotMaster(null, "2", "014", "Flash Man", "Time Stopper",
                                "http://vignette2.wikia.nocookie.net/megaman/images/3/39/Flashmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/c/c3/Flashsprite.png",
                                "Crash Bomber/Metal Blade");

                RobotMaster robotMaster7 = new RobotMaster(null, "2", "015", "Heat Man", "Atomic Fire",
                                "http://vignette3.wikia.nocookie.net/megaman/images/c/ca/Heatmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/8/8e/Heatsprite.png",
                                "Bubble Lead");

                RobotMaster robotMaster8 = new RobotMaster(null, "2", "016", "Wood Man", "Left Shield",
                                "http://vignette1.wikia.nocookie.net/megaman/images/1/14/Woodmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/d/d3/Woodsprite.png",
                                "Atomic Fire/Air Shooter");

                RobotMaster robotMaster9 = new RobotMaster(null, "3", "017", "Needle Man", "Needle Cannon",
                                "http://vignette3.wikia.nocookie.net/megaman/images/2/27/Needlemugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/a/a6/Needlesprite.png",
                                "Gemini Laser");

                RobotMaster robotMaster10 = new RobotMaster(null, "3", "018", "Magnet Man", "Magnet Missile",
                                "http://vignette3.wikia.nocookie.net/megaman/images/d/de/Magnetmugshot.png",
                                "http://vignette1.wikia.nocookie.net/megaman/images/6/6a/Magnetsprite.png",
                                "Spark Shock");

                RobotMaster robotMaster11 = new RobotMaster(null, "3", "019", "Gemini Man", "Gemini Laser",
                                "http://vignette2.wikia.nocookie.net/megaman/images/7/74/Geminimugshot.png",
                                "http://vignette4.wikia.nocookie.net/megaman/images/d/d0/MM10WA3.png",
                                "Search Snake");

                RobotMaster robotMaster12 = new RobotMaster(null, "3", "020", "Hard Man", "Hard Knuckle",
                                "http://vignette1.wikia.nocookie.net/megaman/images/5/59/Hardmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/2/2a/Hardsprite.png",
                                "Magnet Missile");

                RobotMaster robotMaster13 = new RobotMaster(null, "3", "021", "Top Man", "Top Spin",
                                "http://vignette3.wikia.nocookie.net/megaman/images/1/16/Topmugshot.png",
                                "http://vignette1.wikia.nocookie.net/megaman/images/1/11/Topsprite.png",
                                "Hard Knuckle");

                RobotMaster robotMaster14 = new RobotMaster(null, "3", "022", "Snake Man", "Search Snake",
                                "http://vignette3.wikia.nocookie.net/megaman/images/e/e8/Snakemugshot.png",
                                "http://vignette4.wikia.nocookie.net/megaman/images/3/3d/Snakesprite.png",
                                "Needle Cannon");

                RobotMaster robotMaster15 = new RobotMaster(null, "3", "023", "Spark Man", "Spark Shork",
                                "http://vignette1.wikia.nocookie.net/megaman/images/a/a1/Sparkmugshot.png",
                                "http://vignette1.wikia.nocookie.net/megaman/images/0/0b/Sparksprite.png",
                                "Shadow Blade");

                RobotMaster robotMaster16 = new RobotMaster(null, "3", "024", "Shadow Man", "Shadow Blade",
                                "http://vignette3.wikia.nocookie.net/megaman/images/2/28/Shadowmugshot.png",
                                "http://vignette1.wikia.nocookie.net/megaman/images/0/02/Shadowsprite.png",
                                "Top Spin");

                RobotMaster robotMaster17 = new RobotMaster(null, "4", "025", "Bright Man", "Flash Stopper",
                                "http://vignette3.wikia.nocookie.net/megaman/images/2/28/Brightmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/c/c8/Brightsprite.png",
                                "Rain Flush");

                RobotMaster robotMaster18 = new RobotMaster(null, "4", "026", "Toad Man", "Rain Flush",
                                "http://vignette1.wikia.nocookie.net/megaman/images/9/95/Toadmugshot.png",
                                "http://vignette4.wikia.nocookie.net/megaman/images/c/c0/Toadsprite.png",
                                "Drill Bomb");

                RobotMaster robotMaster19 = new RobotMaster(null, "4", "027", "Drill Man", "Drill Bomb",
                                "http://vignette2.wikia.nocookie.net/megaman/images/8/88/Drillmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/2/25/Drillsprite.png",
                                "Dive Missile");

                RobotMaster robotMaster20 = new RobotMaster(null, "4", "028", "Pharaoh Man", "Pharaoh Shot",
                                "http://vignette4.wikia.nocookie.net/megaman/images/c/c0/Pharaohmugshot.png",
                                "http://vignette3.wikia.nocookie.net/megaman/images/b/bb/Pharaohsprite.png",
                                "Flash Stopper");

                RobotMaster robotMaster21 = new RobotMaster(null, "4", "029", "Ring Man", "Ring Boomerang",
                                "http://vignette4.wikia.nocookie.net/megaman/images/b/b3/Ringmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/b/b3/MM10WA4.png",
                                "Pharaoh Shot");

                RobotMaster robotMaster22 = new RobotMaster(null, "4", "030", "Dust Man", "Dust Crusher",
                                "http://vignette2.wikia.nocookie.net/megaman/images/c/c3/Dustmugshot.png",
                                "http://vignette1.wikia.nocookie.net/megaman/images/4/41/Dustsprite.png",
                                "Ring Boomerang");

                RobotMaster robotMaster23 = new RobotMaster(null, "4", "031", "Dive Man", "Dive Missile",
                                "http://vignette4.wikia.nocookie.net/megaman/images/4/4f/Divemugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/d/df/Divesprite.png",
                                "Skull Barrier");

                RobotMaster robotMaster24 = new RobotMaster(null, "4", "032", "Skull Man", "Skull Barrier",
                                "http://vignette4.wikia.nocookie.net/megaman/images/c/c4/Skullmugshot.png",
                                "http://vignette3.wikia.nocookie.net/megaman/images/e/e8/Skullsprite.png",
                                "Dust Crusher");

                RobotMaster robotMaster25 = new RobotMaster(null, "5", "033", "Gravity Man", "Gravity Hold",
                                "http://vignette3.wikia.nocookie.net/megaman/images/2/2e/Gravitymugshot.png",
                                "http://vignette1.wikia.nocookie.net/megaman/images/9/9d/Gravitysprite.png",
                                "Star Crash");

                RobotMaster robotMaster26 = new RobotMaster(null, "5", "034", "Wave Man", "Water Wave",
                                "http://vignette1.wikia.nocookie.net/megaman/images/4/46/Wavemugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/c/cc/Wavesprite.png",
                                "Charge Kick");

                RobotMaster robotMaster27 = new RobotMaster(null, "5", "035", "Stone Man", "Power Stone",
                                "http://vignette1.wikia.nocookie.net/megaman/images/b/b2/Stonemugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/a/ab/Stonesprite.png",
                                "Napalm Bomb");

                RobotMaster robotMaster28 = new RobotMaster(null, "5", "036", "Gyro Man", "Gyro Attack",
                                "http://vignette2.wikia.nocookie.net/megaman/images/f/fe/Gyromugshot.png",
                                "http://vignette3.wikia.nocookie.net/megaman/images/c/c3/Gyrosprite.png",
                                "Gravity Hold");

                RobotMaster robotMaster29 = new RobotMaster(null, "5", "037", "Star Man", "Star Crash",
                                "http://vignette1.wikia.nocookie.net/megaman/images/6/61/Starmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/7/70/Starsprite.png",
                                "Water Wave");

                RobotMaster robotMaster30 = new RobotMaster(null, "5", "038", "Charge Man", "Charge Kick",
                                "http://vignette1.wikia.nocookie.net/megaman/images/3/39/Chargemugshot.png",
                                "http://vignette4.wikia.nocookie.net/megaman/images/1/1a/Chargesprite.png",
                                "Power Stone");

                RobotMaster robotMaster31 = new RobotMaster(null, "5", "039", "Napalm Man", "Napalm Bomb",
                                "http://vignette4.wikia.nocookie.net/megaman/images/f/fd/Napalmmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/a/aa/MM10WA5.png",
                                "Crystal Eye");

                RobotMaster robotMaster32 = new RobotMaster(null, "5", "040", "Crystal Man", "Napalm Bomb",
                                "http://vignette2.wikia.nocookie.net/megaman/images/b/b8/Crystalmugshot.png",
                                "http://vignette2.wikia.nocookie.net/megaman/images/c/ce/Crystalsprite.png",
                                "Gyro Attack");

                robotMasterRepository.saveAll(Arrays.asList(robotMaster1, robotMaster2, robotMaster3, robotMaster4,
                                robotMaster5, robotMaster6, robotMaster7, robotMaster8, robotMaster9, robotMaster10,
                                robotMaster11,
                                robotMaster12, robotMaster13, robotMaster14, robotMaster15, robotMaster16,
                                robotMaster17,
                                robotMaster18, robotMaster19, robotMaster20, robotMaster21, robotMaster22,
                                robotMaster23,
                                robotMaster24, robotMaster25, robotMaster26, robotMaster27, robotMaster28,
                                robotMaster29,
                                robotMaster30, robotMaster31, robotMaster32));
        }
}
