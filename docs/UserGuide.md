---
layout: page
title: User Guide
---
# Welcome to lesSON

***Revolutionise your studying experience with lesSON!***

lesSON is a **desktop application** aimed to help NUS Computer Science undergraduates make flashcards to aid with
their memory work for school content.<br>
Here are some benefits of adopting lesSON in your studying experience:
- Create and Edit flashcards about key concepts taught in your courses
- Take advantage of our implemented **Spaced Repetition** to maximise your memorisation
- Categorise your flashcards based on their courses or topics

On top of these functionalities, we believe that making flashcards must be efficient. Therefore, lesSON is optimized for
use via a **Command Line Interface (CLI)** while still having the benefits of a **Graphical User Interface (GUI)**.
If you type fast, lesSON can get your flashcards done faster than current GUI apps in the industry.

--------------------------------------------------------------------------------------------------------------------

# Table of Contents
1. [Quick start](#quick-start)
2. [Glossary](#glossary)
3. [Feature list](#feature-list)
   - [Adding a FlashCard](#adding-a-flashcard-add)
   - [Deleting a Flashcard](#deleting-a-flashcard--delete)
   - [View All Flashcards](#view-all-flashcards--list)
   - [Editing a Specific Flashcard](#editing-a-specific-flashcard--edit)
   - [Practise Flashcards](#practise-flashcards-practise)
   - [Solve Flashcards](#practise-flashcards-solve)
   - [Setting Difficulty for Flashcards](#setting-difficulty-of-flashcards-set)
4. [Markdown Syntax](#markdown-syntax)
5. [FAQ](#faq)

--------------------------------------------------------------------------------------------------------------------

# Quick start

1. Make sure that you have **Java 11 or above** installed on your computer.
2. Download the latest jar file from [here](https://github.com/AY2324S1-CS2103T-W17-4/tp/releases/tag/v1.3(trial)).
3. Move the jar file installed to a working folder you would store all of your flashcards
4. Launch lesSON.
5. Better understand the GUI using this [guide](#table-of-contents).
6. For new users, we recommend reading this [New User Guide](#table-of-contents).
7. For advanced users, view all feature details in our [feature list](#feature-list).

--------------------------------------------------------------------------------------------------------------------

# Glossary

`Deck` - A scrollable list of flashcards on the GUI.

`Flashcard`- A card created by the user containing its index, question, answer (not shown) and due date.

`Index` - The relative position of a flashcard within the deck.

--------------------------------------------------------------------------------------------------------------------
# Feature list

### Adding a Flashcard `add`
Adds a flashcard to the deck for the user.

**Format:** 

`add q/question a/answer [t/TAG]`


**Examples:**

_A flashcard with only a question and answer field._

`add q/What are the three ways to implement binary systems? a/1s Complement, 2s Complement, and Sign and Magnitude`

_A flashcard with a question, answer and tag field._

`add q/How do you convert from binary to 1s Complement? a/By inverting all the bits, i.e. 0 to 1 and vice versa t/CS2100 t/Number Systems`

#### To Note:
1. No Empty Input after q/, a/ and t/.
2. t/ is optional and not necessary.
3. **Tip**: Tagging is not supported in v1.2 and earlier

#### Expected outputs:

1. Given a correct input, a success message will be shown containing the user's input.
   1. `“New Card added: Question: (question); Answer: (answer)“`
2. Given an incorrect input, an error message will be shown, detailing how the error can be fixed.
   1. `Answers should only contain alphanumeric characters, some special characters and spaces, and it should not be blank`
   2. ```
       Invalid command format!
       add: Adds a card to the deck. Parameters: q/QUESTION a/ANSWER
      ```
#### Usage
1. User Input: `add q/ opcode for R format instructions a/ 000000 t/ CS2100 t/ MIPS` 

2. Successful Output

![result of add command](./images/UserGuide/1.3_add_clean.png)


### Deleting a Flashcard : `delete`
Deletes a flashcard in the deck

**Format:** 

`delete INDEX`

**Examples:**

_Deleting the card in th deck with an index of 2._

`delete 2`

#### To Note:
1. Index must be positive integer.
2. Index cannot exceed size of the deck.

#### Expected outputs:
1. Given a correct input, a success message will be shown containing the details of the deleted flashcard.
   1. `Deleted Card: Question: <provided question>; Answer: <provided answer>`
2. Given an incorrect input, an error message will be shown, detailing how the error can be fixed.
   1. `The card index provided is invalid`
   2. ```
      Invalid command format!
      delete: Deletes the deck identified by the index number used in the displayed card list.
      Parameters: INDEX (must be a positive integer)
      Example: delete 1
      ```

#### Usage:
1. User Input: `delete 1`

2. Successful Output

![result of delete command](./images/UserGuide/1.3_del_clean.png)

### View All Flashcards : `list`
Shows a list of all flashcards in the deck. A keyword may be specified to filter out the list.

Format: `list (q/t)/ (prefix question starts with/ tag)`
Examples:
```
1. list
   (list shows the full list of flashcards)

2. list q/ What
   (list shows all flashcards with questions starting with 'What')

3. list t/ CS2100
   (list shows all flashcards with the CS2100 Tag)

4. list q/ what t/ CS2100
   (list shows all flashcards with questions starting with 'What' and has the CS2100 Tag)
```

#### Acceptable values for each parameters:
1. No Empty Input after q/ and t/.
2. q/ and t/ is optional.

#### Expected output:
```
1. list
   "All cards listed" message will be returned to the user via the CLI
```

#### Usage
![usage of list command](./images/UserGuide/1.3_list.png)

### Editing a Specific Flashcard : `edit`
Edits an existing Flashcard in the deck.

Format: `edit INDEX (q/a)/ (question/answer)`

Examples:
```
1. edit 1 q/ What is the colour of the sun?
   (changes the question at index 1 to “What is the colour of the sun?”)

2. edit 1 a/ Red
   (changes the answer at index 1 to “Red”)
```
#### Expected output:
```
“Successfully edited flashcard” message will be returned to the user via the CLI
“The card index provided is invalid"
```
#### Usage:
1. User Input
   ![usage of edit command](./images/UserGuide/1.3_edit.png)

2. Successful Output
   ![result of edit command](./images/UserGuide/1.3_edit_ans.png)



### Practise Flashcards: `practise`
Practise a single Flashcard in the deck

Format: `practise INDEX`

#### Acceptable values for each parameters:
1. Index must be positive integer
2. Index cannot exceed size of the deck

#### Examples:
```
practise 1
(showcases the question at index 1)
```
#### Expected outputs:
```
practise 1
"Practising question 1 : <provided question>"

practise 10
"The card index provided is invalid"
```

#### Usage:
1. User Input
   ![usage of practise command](./images/UserGuide/1.3_prac.png)

2. Successful Output
   ![result of practise command](./images/UserGuide/1.3_prac_ans.png)

### Solving Flashcards: `solve`
Solves the question at the given index

Format: `solve INDEX`

#### Acceptable values for each parameters:
1. Index must be positive integer
2. Index cannot exceed size of the deck

#### Examples:
```
solve 1
```
#### Expected outputs:
```
solve 1
"Solved Question 1: What pipline protocols are covered
Answer:2"

solve 10
"The card index provided is invalid"
```

#### Usage:
1. User Input
   ![usage of solve command](./images/UserGuide/1.3_solve.png)

2. Successful Output
   ![result of solve command](./images/UserGuide/1.3_solve_ans.png)


### Setting Difficulty of Flashcards: `set`
Setting the difficulty of a flashcard

This difficulty refers to how difficult you found the flashcard.
This flashcard will be rescheduled based on the difficulty, as indicated by their due date.
More difficult cards will appear more often in the practice rotation.
This also takes into account past practices, so the more a card is practised,
the less it will appear in the practice rotation.

Format: set INDEX DIFFICULTY

#### Acceptable values for each parameters:
1. Index must be positive integer
2. Index cannot exceed size of the deck
3. Difficulty must be either ‘easy’, ‘medium’, ‘hard’

#### Example:
```
set 1
```

#### Expected outputs:
```
set 1 d/ easy
"Set Difficulty for Question 1 (Diffculty Level: easy)

set 10 d/ easy
"The card index provided is invalid"
```

#### Usage:
1. User Input
   ![usage of set command](./images/UserGuide/1.3_set.png)

2. Successful Output
   ![result of set command](./images/UserGuide/1.3_set_ans.png)

# MarkDown Syntax

For user who wish to incorporate styling in lesSON, there are 3 font styles currently supported:
1. Bold
2. Italic
3. Underline

### Bold
To bold a line of text, wrap text with `**`

#### Example:
```
edit 1 q/ How many bits can a **Half Adder** add up
```
#### Expected Result:
![usage of bold syntax](./images/UserGuide/1.3_bold.png)

### Italic
To italicise a line of text, wrap text with `*`

#### Example:
```
edit 1 q/ How many bits can a *Half Adder* add up
```
#### Expected Result:
![usage of bold syntax](./images/UserGuide/1.3_italic.png)

### Underline
To underline a line of text, insert `<u>` at the beginning of the text,
and end with `</u>` at the end of the underlined text.

#### Example:
```
edit 1 q/ How many bits can a <u>Half Adder</u> add up
```
#### Expected Result:
![usage of bold syntax](./images/UserGuide/1.3_underline.png)
