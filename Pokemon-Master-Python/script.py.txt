class Pokemon:
    # create and initialize variables to keep track of Pokemon's name, level, type, etc. maximum health is based on level.
    def __init__(self, name, type, level = 5):
        self.name = name
        self.level = level
        self.health = level * 5
        self.max_health = level * 5
        self.type = type
        self.is_knocked_out = False


    def __repr__(self):
        # Printing a pokemon will tell you its name, its type, its level and how much health it has remaining
        return "This level {level} {name} has {health} hit points remaining. They are a {type} type Pokemon".format(level = self.level, name = self.name, health=self.health, type = self.type)

    def lose_health(self, amount_lost):
        self.health -= amount_lost
        if self.health <= 0:
            # knockout if health becomes negative or zero
            self.health = 0
            self.knock_out()
        else:
            print("{name} now has {health} health.".format(name = self.name, health = self.health))
    
    
    def gain_health(self, amount):
        # If health is zero that is pokemon has been knocked out , it should be revived
        if self.health == 0:
            self.revive()
        self.health += amount
        # After gaining health, ensure that it is always less than maximum health available for it
        if self.health >= self.max_health:
            self.health = self.max_health
        print("{name} now has {health} health.".format(name = self.name, health = self.health))
    
    
    def revive(self):
        # Reviving means pokemon is not knocked out anymore
        self.is_knocked_out = False
        print("{name} was revived!".format(name = self.name))

    def knock_out(self):
        # Knocking out sets the is_knock_out variable to true
        self.is_knocked_out = True
        print("{name} was knocked out!".format(name = self.name))

    def attack(self, other_pokemon):
        # Checks to make sure the pokemon isn't knocked out
        if self.is_knocked_out:
            print("{name} can't attack because it is knocked out!".format(name = self.name))
            return
        # When attacking pokemon has a disadvantage , damage is half
        if (self.type == "Fire" and other_pokemon.type == "Water") or (self.type == "Water" and other_pokemon.type == "Grass") or (self.type == "Grass" and other_pokemon.type == "Fire"):
            print("{my_name} attacked {other_name} for {damage} damage.".format(my_name = self.name, other_name = other_pokemon.name, damage = round(self.level * 0.5)))
            print("It's not very effective")
            other_pokemon.lose_health(round(self.level * 0.5))
        # When both the pokemons are of the same type, damage is at equal level
        if (self.type == other_pokemon.type):
            print("{my_name} attacked {other_name} for {damage} damage.".format(my_name = self.name, other_name = other_pokemon.name, damage = self.level))
            print("Pokemons are of the same type No great effect")
            other_pokemon.lose_health(self.level)
        # When arracking pokemon has an advantgae, damage is twice
        if (self.type == "Fire" and other_pokemon.type == "Grass") or (self.type == "Water" and other_pokemon.type == "Fire") or (self.type == "Grass" and other_pokemon.type == "Water"):
            print("{my_name} attacked {other_name} for {damage} damage.".format(my_name = self.name, other_name = other_pokemon.name, damage = self.level * 2))
            print("It's super effective")
            other_pokemon.lose_health(self.level * 2)


# Three classes that are subclasses of Pokemon. Charmander is a fire type, Squirtle is a Water type, and Bulbasaur is a Grass type.
class Charmeleon(Pokemon):
    def __init__(self, level = 5):
        super().__init__("Charmeleon", "Fire", level)

class Golduck(Pokemon):
    def __init__(self, level = 5):
        super().__init__("Golduck", "Water", level)

class Venusaur(Pokemon):
    def __init__(self, level = 5):
        super().__init__("Venusaur", "Grass", level)

class Trainer:
    # AA Trainer can have up to 6 Pokémon, which we stored in a list. A trainer also has a name, and a number of potions they can use to heal their Pokémon. A trainer also has a “currently active Pokémon”, which we represented as a number.
    def __init__(self, pokemon_list, 
    num_potions, name):
        self.pokemons = pokemon_list
        self.potions = num_potions
        self.current_pokemon = 0
        self.name = name

    def __repr__(self):
        # Prints the name of the trainer, the pokemon they currently have, and the current active pokemon.
        print("The trainer {name} has the following pokemons".format(name = self.name))
        for pokemon in self.pokemons:
            print(pokemon)
        return "The current active pokemon is {name}".format(name = self.pokemons[self.current_pokemon].name)

    def switch_active_pokemon(self, new_active):
        # Switches to new active pokemon
        if new_active < len(self.pokemons) and new_active >= 0:
            if self.pokemons[new_active].is_knocked_out:
                print("{name} is knocked out - can't switch to this pokemon".format(name = self.pokemons[new_active].name))
            elif new_active == self.current_pokemon:
                print("{name} is already your active pokemon".format(name = self.pokemons[new_active].name))
            else:
                self.current_pokemon = new_active
                print(" {name} is your current pokemon!".format(name = self.pokemons[self.current_pokemon].name))

    def use_potion(self):
        # Use a potion on active pokemon
        if self.potions > 0:
            print("You used a potion on {name}.".format(name = self.pokemons[self.current_pokemon].name))
            # A potion makes a pokemon gain 20 health
            self.pokemons[self.current_pokemon].gain_health(20)
            self.potions -= 1
        else:
            print("You don't have any more potions")

    def attack_other_trainer(self, other_trainer):
        my_pokemon = self.pokemons[self.current_pokemon]
        other_pokemon = other_trainer.pokemons[other_trainer.current_pokemon]
        my_pokemon.attack(other_pokemon)

# Six pokemon are made with different levels. (If no level is given, it is level 5)
p1 = Charmeleon(7)
p2 = Golduck()
p3 = Golduck(1)
p4 = Venusaur(10)
p5 = Venusaur()
p6 = Golduck(2)

trainer_one = Trainer([p1, p2, p3], 3, "Priya")
trainer_two = Trainer([p4, p5, p6], 5, "Vignesh")

print(trainer_one)
print(trainer_two)

# Testing attacking, giving potions, and switching pokemon.
trainer_one.attack_other_trainer(trainer_two)
trainer_two.attack_other_trainer(trainer_one)
trainer_two.use_potion()
trainer_one.attack_other_trainer(trainer_two)
trainer_two.switch_active_pokemon(0)
trainer_two.switch_active_pokemon(1)