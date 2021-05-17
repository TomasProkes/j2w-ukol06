package cz.czechitas.java2webapps.ukol6.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitatyRepository {

    private final List<String> seznamCitatu = new ArrayList<>();
    private final List<String> seznamItCitatu;
    private final List<String> seznamSportovnichCitatu;
    private final List<String> seznamMurphyhoZakonu;

    public CitatyRepository() {

        this.seznamItCitatu = List.of(
                "Debugging /de·bugh·ing/ (verb): The Classic Mystery Game where you are the detective, the victim, and the murderer.",
                "A user interface is like a joke. If you have to explain it, it's not that good.",
                "To replace programmers with robots, clients will have to accurately describe what they want. We're safe.",
                "I have a joke on programming but it only works on my computer.",
                "99 little bugs in the code, 99 bugs in the code. Take one down, patch it around. 127 little bugs in the code…",
                "When I wrote this code, only God & I understood what it did. Now… Only God knows.",
                "Programmer (noun.): A machine that turns coffee into code.",
                "Real programmers count from 0.",
                "Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live.",
                "A misplaced decimal point will always end up where it will do the greatest damage.",
                "A good programmer looks both ways before crossing a one-way street.",
                "C is quirky, flawed, and an enormous success.",
                "Beta is Latin for still doesn’t work.",
                "Hey! It compiles! Ship it!",
                "Experience is the name everyone gives to their mistakes.",
                "If brute force doesn’t solve your problems, then you aren’t using enough.",
                "The best thing about a boolean is even if you are wrong, you are only off by a bit.",
                "The nice thing about standards is that there are so many to choose from.",
                "There is no place like 127.0.0.1",
                "To err is human, but for a real disaster you need a computer.",
                "Weeks of coding can save you hours of planning.",
                "I love deadlines. I like the whooshing sound they make as they fly by.",
                "Measuring programming progress by lines of code is like measuring aircraft building progress by weight.",
                "The problem with troubleshooting is that trouble shoots back.",
                "Walking on water and developing software from a specification are easy if both are frozen.",
                "Computers are fast; programmers keep it slow.",
                "Programming can be fun, and so can cryptography; however, they should not be combined.",
                "Software and cathedrals are much the same — first we build them, then we pray.",
                "Any given program, when running, is obsolete."
        );

        this.seznamSportovnichCitatu = List.of(
                "Rugby is a beastly game played by gentlemen; soccer is a gentleman’s game played by beasts; football is a beastly game played by beasts.",
                "The rules of soccer are very simple, basically it is this: if it moves, kick it. If it doesn’t move, kick it until it does.",
                "The trouble with referees is that they know the rules, but they do not know the game.",
                "Football would become an even better game if someone could invent a ball that kicks back.",
                "A computer once beat me at chess, but it was no match for me at kick boxing.",
                "Rugby is a good occasion for keeping thirty bullies far from the center of the city.",
                "Baseball is almost the only orderly thing in a very un-orderly world. If you get three strikes, even the best lawyer in the world can’t get you off.",
                "Baseball is like church. Many attend; few understand.",
                "Serious sport is war minus the shooting.",
                "Playing polo is like trying to play golf during an earthquake.",
                "All hockey players are bilingual. They know English and profanity.",
                "The first half of the match was even; the second half was even worse.",
                "Sports are the reason I am out of shape. I watch them all on TV.",
                "I've never lost a game. I just ran out of time.",
                "Pro football is like nuclear warfare. There are no winners, only survivors.",
                "One day of practice is like one day of clean living. It doesn't do you any good.",
                "If practice makes perfect, and no one is perfect, why practice?",
                "If you think it's hard to meet new people, try picking up the wrong golf ball.",
                "The fewer rules a coach has, the fewer rules there are for players to break."
        );

        this.seznamMurphyhoZakonu = List.of(
                "Anything that can go wrong will go wrong.",
                "Left to themselves, things tend to go from bad to worse.",
                "Nothing is as easy as it looks.",
                "Everything takes longer than you think.",
                "If there is a possibility of several things going wrong, the one that will cause the most damage will be the one to go wrong.",
                "If there is a worse time for something to go wrong, it will happen then.",
                "If anything simply cannot go wrong, it will anyway.",
                "If everything seems to be going well, you have obviously overlooked something.",
                "Whenever you set out to do something, something else must be done first.",
                "Every solution breeds new problems.",
                "Murphy's Law of Thermodynamics: Things get worse under pressure.",
                "Quantization Revision of Murphy's Laws: Everything goes wrong all at once.",
                "Matter will be damaged in direct proportion to its value.",
                "Logic is a systematic method of coming to the wrong conclusion with confidence.",
                "Technology is dominated by those who manage what they do not understand.",
                "An expert is one who knows more and more about less and less until he knows absolutely everything about nothing.",
                "All great discoveries are made by mistake.",
                "Nothing ever gets built on schedule or within budget.",
                "A meeting is an event at which the minutes are kept and the hours are lost.",
                "The first myth of management is that it exists.",
                "A failure will not appear till a unit has passed final inspection.",
                "New systems generate new problems.",
                "The primary function of the design engineer is to make things difficult for the fabricator and impossible for the serviceman.",
                "If you can't understand it, it is intuitively obvious.",
                "If an experiment works, something has gone wrong.",
                "When all else fails, read the instructions.",
                "Any instrument when dropped will roll into the least accessible corner.",
                "Any simple theory will be worded in the most complicated way.",
                "When working toward the solution of a problem, it always helps if you know the answer.",
                "A memorandum is written not to inform the reader but to protect the writer.",
                "When the plane you are on is late, the plane you want to transfer to is on time.",
                "Army Law: If it moves, salute it; if it doesn't move, pick it up; if you can't pick it up, paint it green."
        );

        this.seznamCitatu.addAll(seznamItCitatu);
        this.seznamCitatu.addAll(seznamSportovnichCitatu);
        this.seznamCitatu.addAll(seznamMurphyhoZakonu);
    }

    public int pocet() {
        return seznamCitatu.size();
    }

    public int pocet(String type) {
        switch (type) {
            case "it-quote":
                return seznamItCitatu.size();
            case "sports-quote":
                return seznamSportovnichCitatu.size();
            case "murphys-law":
                return seznamMurphyhoZakonu.size();
            default:
                return seznamCitatu.size();
        }
    }

    public String citat(int poradi) {
        int idx = poradi - 1;
        return seznamCitatu.get(idx);
    }

    public String citat(int poradi, String type) {
        int idx = poradi - 1;
        switch (type) {
            case "it-quote":
                return seznamItCitatu.get(idx);
            case "sports-quote":
                return seznamSportovnichCitatu.get(idx);
            case "murphys-law":
                return seznamMurphyhoZakonu.get(idx);
            default:
                return seznamCitatu.get(idx);
        }
    }
}
