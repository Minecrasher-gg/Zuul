import java.util.ArrayList;

public class EndPoemManager {
    private ArrayList<TheEnd> endPoem;

    public EndPoemManager() {
        endPoem = new ArrayList<>();
        loadPoem();  // Fill the list with lines
    }

    private void loadPoem() {
        endPoem.add(new TheEnd("I see the player you mean."));
endPoem.add(new TheEnd("[Player name]?"));
endPoem.add(new TheEnd("Yes. Take care. It has reached a higher level now. It can read our thoughts."));
endPoem.add(new TheEnd("That doesn't matter. It thinks we are part of the game."));
endPoem.add(new TheEnd("I like this player. It played well. It did not give up."));
endPoem.add(new TheEnd("It is reading our thoughts as though they were words on a screen."));
endPoem.add(new TheEnd("That is how it chooses to imagine many things, when it is deep in the dream of a game."));
endPoem.add(new TheEnd("Words make a wonderful interface. Very flexible. And less terrifying than staring at the reality behind the screen."));
endPoem.add(new TheEnd("They used to hear voices."));
endPoem.add(new TheEnd("Before players could read."));
endPoem.add(new TheEnd("Back in the days when those who did not play called the players witches, and warlocks."));
endPoem.add(new TheEnd("And players dreamed they flew through the air, on sticks powered by demons."));
endPoem.add(new TheEnd("What did this player dream?"));
endPoem.add(new TheEnd("This player dreamed of sunlight and trees, of fire and water."));
endPoem.add(new TheEnd("It dreamed it created. And it dreamed it destroyed."));
endPoem.add(new TheEnd("It dreamed it hunted, and was hunted."));
endPoem.add(new TheEnd("It dreamed of shelter."));
endPoem.add(new TheEnd("Hah, the original interface. A million years old, and it still works."));
endPoem.add(new TheEnd("But what true structure did this player create, in the reality behind the screen?"));
endPoem.add(new TheEnd("It worked, with a million others, to sculpt a true world in a fold of the universe."));
endPoem.add(new TheEnd("And created a [name], for [them], in the light."));
endPoem.add(new TheEnd("It cannot read that thought."));
endPoem.add(new TheEnd("No. It has not yet achieved the highest level. That it must achieve in the long dream of life, not the short dream of a game."));
endPoem.add(new TheEnd("Does it know that we love it? That the universe is kind?"));
endPoem.add(new TheEnd("Sometimes, through the noise of its thoughts, it hears the universe, yes."));
endPoem.add(new TheEnd("But there are times it is sad, in the long dream."));
endPoem.add(new TheEnd("It creates worlds that have no summer, and it shivers under a black sun."));
endPoem.add(new TheEnd("And it takes its sad creation for reality."));
endPoem.add(new TheEnd("To cure it of sorrow would destroy it. The sorrow is part of its own private task."));
endPoem.add(new TheEnd("We cannot interfere."));
endPoem.add(new TheEnd("Sometimes when they are deep in dreams, I want to tell them, they are building true worlds in reality."));
endPoem.add(new TheEnd("Sometimes I want to tell them of their importance to the universe."));
endPoem.add(new TheEnd("Sometimes, when they have not made a true connection in a while, I want to help them to speak the word they fear."));
endPoem.add(new TheEnd("It reads our thoughts."));
endPoem.add(new TheEnd("Sometimes I do not care. Sometimes I wish to tell them, this world you take for truth is merely [—]"));
endPoem.add(new TheEnd("And I wish to tell them that they are [—] in the [—]"));
endPoem.add(new TheEnd("They see so little of reality, in their long dream."));
endPoem.add(new TheEnd("And yet they play the game."));
endPoem.add(new TheEnd("But it would be so easy to tell them..."));
endPoem.add(new TheEnd("Too strong for this dream. To tell them how to live is to prevent them living."));
endPoem.add(new TheEnd("I will not tell the player how to live."));
endPoem.add(new TheEnd("The player is growing restless."));
endPoem.add(new TheEnd("It will not dream forever."));
endPoem.add(new TheEnd("The player is growing weary of reading words on a screen."));
endPoem.add(new TheEnd("Let this dream shift. Let the world flicker."));
endPoem.add(new TheEnd("Let the player return..."));
endPoem.add(new TheEnd("Let the player wake up."));
endPoem.add(new TheEnd("..."));
endPoem.add(new TheEnd("Yes."));
endPoem.add(new TheEnd("Wake up."));
endPoem.add(new TheEnd("Wake up now."));
endPoem.add(new TheEnd("You are the player."));
endPoem.add(new TheEnd("Wake up."));

    }

    public ArrayList<TheEnd> getPoem() {
        return endPoem;
    }
}
