---
layout: page
title: User Guide
---

Managera is a **desktop app that provides event organisers with a convenient method of keeping track of upcoming 
[events](#glossary) and the details of their [participants](#glossary)**. It does not handle communication between the event organiser and the 
participants.

Managera is OS-independent meaning it will work on any operating system. (Windows, MacOS, Linux)

## Table of Contents
- [**What this user guide is for**](#what-this-user-guide-is-for)
- [**How to use this user guide**](#how-to-use-this-user-guide)
- [**Quick start**](#quick-start)
- [**Features**](#features)
    * [Participant](#participant)
        * [Adding a Participant: `add`](#adding-a-participant-add)
        * [Deleting a Participant: `delete`](#deleting-a-participant--delete)
        * [Editing a Participant: `edit`](#editing-a-participant--edit)
        * [Locating Participants by name: `find`](#locating-participants-by-name-find)
        * [Listing all Participants: `list`](#listing-all-participants--list)
        * [Viewing a Participant's details: `view`](#viewing-a-participants-details-view)
        * [Adding Next-of-Kin to a Participant: `addNok`](#adding-next-of-kin-to-a-participant-addnok)
        * [Removing Next-of-Kin from a Participant: `deleteNok`](#removing-next-of-kin-from-a-participant-deletenok)
    * [Event](#event)
        * [Adding an event: `addEvent`](#adding-an-event-addevent)
        * [Deleting an event: `deleteEvent`](#deleting-an-event--deleteevent)
        * [Editing an event: `editEvent`](#editing-an-event--editevent)
        * [Marking an Event as done: `done`](#marking-an-event-as-done-done)
        * [Locating Events by name: `findEvent`](#locating-events-by-name-findevent)
        * [Filtering Events by time: `filterEvents`](#filtering-events-by-time-filterevents)
        * [Sorting Events by time: `sortEvents`](#sorting-events-by-time-sortevents)
        * [Listing all Events: `listEvents`](#listing-all-events-listevents)
        * [Showing an Event's details: `showDetails`](#showing-an-events-details-showdetails)
        * [Adding a Participant to an Event: `enroll`](#adding-a-participant-to-an-event-enroll)
        * [Remove a Participant from an Event: `expel`](#removing-a-participant-from-an-event-expel)
        * [Showing an Event's Participants: `showParticipants`](#showing-an-events-participants-showparticipants)
    * [Miscellaneous](#miscellaneous)
        * [Viewing help: `help`](#viewing-help--help)
        * [Clearing all Data: `clear`](#clearing-all-data--clear)
        * [Exiting the program: `exit`](#exiting-the-program--exit)
- [**Saving the data**](#saving-the-data)
- [**Editing the data file**](#editing-the-data-file)
- [**Glossary**](#glossary)
- [**FAQ**](#faq)
- [**Command summary**](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## What this user guide is for

This user guide aims to give a brief overview of what Managera is and what features it has.
It is intended mainly for first-time users or beginners to Managera, but experienced users may still use it for 
reference.

It contains instructions for [how to set up Managera](#quick-start), [how to use certain features](#features) 
and answers to some [commonly-asked questions](#faq). You may also use this user guide as a
[quick reference](#command-summary) to any [commands](#glossary) once you are more experienced with Managera.

If this is your first time using Managera, or your first time using this user guide, you are strongly advised to
look through the [next section](#how-to-use-this-user-guide).

--------------------------------------------------------------------------------------------------------------------
## How to use this user guide

If this is the first time you are using Managera, you are strongly advised to visit the [Quick Start](#quick-start) 
section to learn how to set up Managera
and get started.

If there are any doubts on how certain commands are used, you can look for the description of the command in the 
[Features](#features) section or have a brief overview in the [Command Summary](#command-summary) section.

If there are any terms used in this user guide you are unclear of or do not understand, their definitions may be found 
in the [Glossary](#glossary).

For any other questions about Managera, you may refer to the [FAQ](#faq) section.

You can quickly jump to any of the sections by using the [Table of Contents](#table-of-contents) above.

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. [Ensure](https://twallet.telangana.gov.in/TABiometric/data/Java%20Check.pdf) you have Java `11` or 
   above installed in your Computer.

2. If your computer does not have Java `11`, obtain the installation package from 
   [here](https://www.oracle.com/java/technologies/downloads/#java11) and follow the instructions 
   [here](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html).

3. Download the latest release `managera.jar` from [here](https://github.com/AY2122S1-CS2103T-T10-2/tp/releases).

4. Copy `managera.jar` to a new folder which will act as the _home folder_ for Managera.

5. Double-click `managera.jar` to start the app. The GUI similar to the one below should appear in a few seconds. Note 
   how the app contains some sample data.<br>
   ![Ui](images/Ui_labelled.png)

6. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will 
   open the help window. <br>
   Some example commands you can try:

   * **`list`** : Lists all Participants.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a Participant 
     named `John Doe` to Managera.

   * **`delete`**`3` : Deletes the 3rd Participant shown in the current list.

   * **`clear`** : Deletes all Participants and Events.
     
   * **`addEvent n/My First Event d/2021-01-01`** : Adds a new Event to the list called 'My First Event'.
     
   * **`sortEvents`** : Sorts the current list of Events in chronological order.

   * **`exit`** : Exits the app.

7. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the [parameters](#glossary) to be supplied by the user.<br>
  e.g. in `addEvent n/NAME d/DATE`, `n/NAME` and `d/DATE` are parameters which can be used as 
  `addEvent n/CS2103T Final d/2021-11-23`.

* Items in square brackets are optional.<br>
  e.g. `addEvent n/NAME d/DATE [t/TIME]` can be used as `addEvent n/CS2103T Final d/2021-11-23 t/1700` or as 
  `addEvent n/CS2103T Final d/2021-11-23`.

* Parameters with [prefixes](#glossary) can be in any order.<br>
  e.g. if the command specifies `n/NAME d/DATE`, `d/DATE n/NAME` is also acceptable.

* Parameters without prefixes needs to be followed strictly.<br>
  e.g. `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [d/BIRTHDATE]` INDEX must strictly be the first parameter 
  while the others with prefix can be in any order after that.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of 
  the parameter will be taken.<br>
  e.g. if you specify `t/1700 t/1800`, only `t/1800` will be taken.

* If a command does not take in any parameters, (namely `help`, `list`, `clear`, `sortEvents` and 
  `exit`) then any extra words added after the command will be ignored.<br>
  e.g. if the command specifies `sortEvents 123`, it will be interpreted as `sortEvents`.

</div>

## Participant

The following commands deal with the handling of Participants in Managera. They can help you: 
* [Add a Participant](#adding-a-participant-add), 
* [Delete a Participant](#deleting-a-participant--delete), 
* [Edit a Participants](#editing-a-participant--edit), 
* [Locate Participants by name](#locating-participants-by-name-find), 
* [List all Participants](#listing-all-participants--list), 
* [View a Participant's details](#viewing-a-participants-details-view), 
* [Add Next-of-Kin to a Participant](#adding-next-of-kin-to-a-participant-addnok) and 
* [Remove Next-of-Kin from a Participant](#removing-next-of-kin-from-a-participant-deletenok).

### Adding a Participant: `add`

Adds a Participant to Managera.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [d/BIRTHDATE]`

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` - Adds a Participant whose name is 
  John Doe with given phone number, email and address to the Participant list.
* `add n/Betsy Crowe e/betsycrowe@example.com a/Newgate Prison p/1234567` - Adds a Participant whose name is Betsy 
  Crowe with given phone number, email and address to the Participant list.

<br>![result for 'add n/Betsy Crowe ...'](images/addBetsyResult.png)

### Deleting a Participant : `delete`

Deletes the specified Participant from Managera.

Format: `delete INDEX`

* Deletes the Participant at the specified `INDEX`.
* The index refers to the index number of the Participant as shown in the displayed Participant list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `delete 3` - Deletes the 3rd Participant in the displayed Participant list.
* `list` followed by `delete 2` - Deletes the 2nd Participant in the full Participant list. 
  Find out more about `list` [here](#listing-all-participants--list).
* `find Betsy` followed by `delete 1` - Deletes the 1st Participant in the results of the `find` command.
  Find out more about `find` [here](#locating-participants-by-name-find).

### Editing a Participant : `edit`

Edits an existing Participant in Managera.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [d/BIRTHDATE]`

* Edits the Participant at the specified `INDEX`. The index refers to the index number of the Participant as shown 
  in the displayed Participant list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` - Edits the phone number and email address of the 1st Participant 
   in the displayed Participant list to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower` - Edits the name of the 2nd Participant in the displayed Participant list to be 
   `Betsy Crower`.

### Locating Participants by name: `find`

Finds Participant(s) whose names contain any of the given keywords. It is possible for there to be no matches.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g. `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Participants whose names match at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` - Finds any Participants with the name "John"; possible matches: `John` and `John Doe`.
* `find alex david` - Finds any Participants with "Alex" or "David" in their names; 
  possible matches: `Alex Yeoh` and `David Li`<br>
  
<br>![result for 'find alex david'](images/findAlexDavidResult.png)

### Listing all Participants : `list`

Shows a list of all Participants in Managera.

Format: `list`

### Viewing a Participant's details: `view`

Displays the details of a Participant in Managera.

Format: `view INDEX`

* Views the details of the Participant at the specified `INDEX`.
* The index refers to the index number of the Participant as shown in the displayed Participant list.
* The index **must be a positive integer** 1, 2, 3, …​

Example Usage:
* `view 1` - Displays the details of the 1st Participant in the displayed Participant list.
* `list` followed by `view 2` - Displays the details of the 2nd Participant in the full Participant list.
  Find out more about `list` [here](#listing-all-participants--list).
* `find Betsy` followed by `delete 1` - Displays the details of the 1st Participant in the results of the 
  `find` command. Find out more about `find` [here](#locating-participants-by-name-find).

<br>![result for 'view 1'](images/viewFirstResult.png)

### Adding Next-of-Kin to a Participant: `addNok`

Adds a Next-of-Kin to a Participant.

Format: `addNok INDEX n/NAME p/PHONE tag/TAG`

* Adds a Next-of-Kin to the Participant at the specified `INDEX`.
* The index refers to the index number of the Participant as shown in the displayed Participant list.
* The index **must be a positive integer** 1, 2, 3, …​
* A Next-of-Kin with the same name cannot be assigned to the same Participant.

Example Usage:
* `addNok 1 n/Jannette Yeo p/88734323 tag/Spouse` - Adds a Next-of-Kin whose name is Janette Yeo with contact number
  88734323 and tag Spouse to the first Participant.

### Removing Next-of-Kin from a Participant: `deleteNok`

Removes a Next-of-Kin from a Participant.

Format: `deleteNok INDEX_1 INDEX_2`

* Removes the Next-of-Kin at specified `INDEX_1` from the Participant at specified index `INDEX_2`.
* `INDEX_1` refers to the index number of the Next-of_Kin as shown in the Participant's list of Next-of-Kins.
* `INDEX_2` refers to the index number of the Participant as shown in the displayed Participant list.
* The index **must be a positive integer** 1, 2, 3, …​

* `deleteNok 2 1` - Removes the 2nd Next-of-Kin from the 1st Participant.

<br>![result for 'deleteNok 1 2'](images/deleteNokSecondFirstResult.png)

## Event

The following commands deal with the handling of Events in Managera. They can help you:
* [Add an Event](#adding-an-event-addevent), 
* [Delete an Event](#deleting-an-event--deleteevent), 
* [Edit an Event](#editing-an-event--editevent),
* [Mark an Event as done](#marking-an-event-as-done-done), 
* [Locate Events by name](#locating-events-by-name-findevent), 
* [Filter Events by time](#filtering-events-by-time-filterevents), 
* [Sort Events by time](#sorting-events-by-time-sortevents), 
* [List all Events](#listing-all-participants--list), 
* [Show an Event's details](#showing-an-events-details-showdetails),
* [Add a Participant to an Event](#adding-a-participant-to-an-event-enroll), 
* [Remove a Participant from an Event](#removing-a-participant-from-an-event-expel) and 
* [Show Participants of an Event](#showing-an-events-participants-showparticipants).

### Adding an event: `addEvent`

Adds an Event to Managera.

Format: `addEvent n/NAME d/DATE [t/TIME]` 

Example Usage:
* `addEvent n/CS2100 Finals d/2021-11-20 t/0900` - Adds an Event "CS2100 Finals" on 20th November 2021 9:00am 
  to the Event list.
* `addEvent n/240Km Marathon d/2022-08-20` - Adds a full-day Event "240 km Marathon" on 20th August 2022 
  to the Event list.

### Deleting an event : `deleteEvent`

Deletes the specified Event from Managera.

Format: `deleteEvent INDEX`

* Deletes the Event at the specified `INDEX`.
* The index refers to the index number of the Event as shown in the displayed Event list.
* The index **must be a positive integer** 1, 2, 3, …​

Example Usage:
* `delete 5` - Deletes the 5th Event in the displayed Event list.
* `listEvents` followed by `deleteEvent 2` - Deletes the 2nd Event in the full Event list.
  Find out more about `listEvents` [here](#listing-all-events-listevents).
* `filterEvents d/2021-09-18` followed by `deleteEvent 1` - Deletes the 1st Event in the results of the `filterEvents` 
  command. Find out more about `filterEvents` [here](#filtering-events-by-time-filterevents).

### Editing an event : `editEvent`

Edits an existing Event in Managera.

Format: `editEvent INDEX [n/EVENTNAME] [d/EVENTDATE] [t/EVENTTIME]`

* Edits the Event at the specified `INDEX`.
* The index refers to the index number of the Event as shown in the displayed Event list.
* The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* You can remove the time of Event by typing `t/` and leaving a blank after it. This is only possible
due to the fact that time is optional for an Event.

Example Usage:
* `editEvent 1 n/241Km Marathon` - Edits the event name of the 1st Event in the displayed Event list to be 
  `241Km Marathon`.
* `editEvent 2 n/2103T milestone d/2021-10-21 t/2359` - Edits the event name, event date and event time of the 
  2nd Event in the displayed Event list to be `2103T milestone`, `2021-10-21` and `2359` respectively.

<br>![result for 'editEvent 2 n/2103T milestone ...'](images/editEventSecondResult.png)

### Marking an Event as done: `done`

Marks the specified Event in Managera as done.

Format: `done INDEX`

* Marks the Event at the specified `INDEX` as done.
* The index refers to the index number of the Event shown in the displayed Event list.
* The index **must be a positive integer** 1, 2, 3, …​

Example Usage:
* `done 3` - Marks the 3rd Event in the displayed Event list as done.
* `listEvents` followed by `done 2` - Marks the 2nd Event in the full Event list as done.
  Find out more about `listEvents` [here](#listing-all-events-listevents).
* `filterEvents d/2021-09-18` followed by `done 1` - Marks the 1st Event in the results of the `filterEvents` command 
  as done. Find out more about `filterEvents` [here](#filtering-events-by-time-filterevents).

### Locating Events by name: `findEvent`

Finds Events whose names contain any of the given keywords. It is possible for there to be no matches.

Format: `findEvent KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g. `marathon` will match `Marathon`
* The order of the keywords does not matter. e.g. `Marathon Commencement` will match `Commencement Marathon`
* Only the name is searched.
* Only full words will be matched e.g. `Marath` will not match `Marathon`
* Events matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Marathon Commencement` will return `240Km Marathon`, `Marathon Commencement`

Examples:
* `findEvent party` - Finds any Events with the name "party"; possible matches: `beach party` and `Christmas party`
* `findEvent marathon meeting` - Finds any Events with "marathon" or "meeting" in their names;
  possible matches:  `240Km Marathon`, `project meeting`<br>

### Filtering Events by time: `filterEvents`

Filters the Event list for Events occurring on a specific date and optionally, time.

Format: `filterEvents d/DATE [t/TIME]`

Example Usage:
* `filterEvents d/2021-09-18` - Filters the displayed Event list to show only Events occurring on 18th September 2021.
* `filterEvents d/2021-09-18 t/0900` - Filters the displayed Event list to show only Events occurring on 
  18th September 2021 9am.

### Sorting Events by time: `sortEvents`

Sorts the displayed Event list in chronological order with earlier Events at the top and later Events 
at the bottom.

<br>![result for 'sortEvents'](images/sortEventsResult.png)

Format: `sortEvents`

### Listing all Events: `listEvents`

Show a list of all events in Managera.

Format: `listEvents`

### Showing an Event's details: `showDetails`

Displays the details of the Event at the specified index.

Format: `showDetails INDEX`

* Views the details of the Event at the specified `INDEX`.
* The index refers to the index number of the Event as shown in the displayed Event list.
* The index **must be a positive integer** 1, 2, 3, …​

Example Usage:
* `showDetails 1` - Displays the details of the 1st Event in the displayed Event list.
* `listEvents` followed by `showDetails 2` - Displays the details of the 2nd Event in the full Event list.
  Find out more about `listEvents` [here](#listing-all-events-listevents).
* `filterEvents d/2021-09-18` followed by `showDetails 1` - Displays the details of the 1st Event in the results of 
  the `filterEvents` command. Find out more about `filterEvents` [here](#filtering-events-by-time-filterevents).

### Adding a Participant to an Event: `enroll`

Adds a Participant with the first specified index to the Event with the second specified index.

Format:
`enroll INDEX_1 INDEX_2`

* Adds the Participant at specified `INDEX_1` to the Event at specified index `INDEX_2`.
* `INDEX_1` refers to the index number of the Participant as shown in the displayed Participant list.
* `INDEX_2` refers to the index number of the Event as shown in the displayed Event list.
* The indexes **must be positive integers** 1, 2, 3, …​

Example Usage:
* `enroll 1 2` - Adds the 1st Participant in the displayed Participant list to the 2nd Event in the displayed Event
  list.

<br>![result for 'enroll 1 2'](images/enrollFirstSecondResult.png)

### Removing a Participant from an Event: `expel`

Removes the Participant with the first specified index from the Event with the second specified index.

Format: `expel INDEX_1 INDEX_2`

* Removes the Participant at specified `INDEX_1` from the Event at specified index `INDEX_2`.
* `INDEX_1` refers to the index number of the Participant as shown in the displayed Participant list.
* `INDEX_2` refers to the index number of the Event as shown in the displayed Event list.
* The indexes **must be positive integers** 1, 2, 3, …​

Example Usage:
* `expel 3 1` - Removes the 3rd Participant in the displayed Participant list from the 1st Event in the displayed Event
  list.

### Showing an Event's Participants: `showParticipants`

Displays the list of participants of the Event at the specified index.

Format: `showParticipants INDEX`

* Views the Participants of the Event at the specified `INDEX`.
* The index refers to the index number of the Event as shown in the displayed Event list.
* The index **must be a positive integer** 1, 2, 3, …​

Example Usage:
* `showParticipants 4` - Displays the list of participants of the 4th Event in the displayed Event list.

<br>![result for 'showParticipants 4'](images/showParticipantsFourthResult.png)

## Miscellaneous

The following features are additional and deal with other actions that you may want to do in Managera.

### Viewing help : `help`

Opens a popup window with a link to this user guide. You can always return here whenever you need help 
or just want to learn more about Managera.

![help message](images/helpMessage.png)

Format: `help`

### Clearing all Data : `clear`

Clears all Events and Participants from Managera.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is irreversible! Please make sure you want to permanently delete all your data before
entering this command.
</div>

Format: `clear`

<br>![result for 'clear'](images/clearResult.png)

### Exiting the program : `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## Saving the data

Managera saves data in the hard disk automatically after any command that changes the data. 
There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## Editing the data file

Managera's data is saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to 
update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Managera will discard all data and start with an empty data 
file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## Glossary

**Participant**: A person that is participating in or attending some given event.<br>

**Event**: An event that will be conducted in real life e.g., a competition, meeting, social activity etc.<br>

**Command**: A command is a specific instruction that you give to Managera to perform a certain action, like adding a 
new Participant to the list. Commands will be the primary way that you will interact with Managera.<br>

**Parameter**: Parameters are pieces of data that must be passed to certain commands to tell Managera which actions to 
perform. For example, the `done` command requires a single integer as a parameter so that it knows which event to mark 
as done.<br>

**Prefix**: Prefixes are unique identifiers in front of parameters so that Managera understands what kind of values 
they are. For example, the prefix "n/" lets Managera know that a name is expected to follow behind it, while the 
prefix "d/" lets Managera know that a date is expected.<br>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another computer?<br>
**A**: Install and run Managera in the other computer. Then overwrite the empty save file it creates with the save file 
from your previous computer. The save file of Managera is found in `[JAR file location]/data/addressbook.json`.

**Q**: Does Managera have a mobile version?<br>
**A**: Managera currently does not operate on any other platform other than desktop.

**Q**: I accidentally exited Managera by closing the window rather than using the given `exit` command, what do I 
do?<br>
**A**: Since Managera automatically saves your data to the hard disk after each change, it should not reverse any 
changes you have made in the session. Your progress is most likely preserved after restarting Managera.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add Participant** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS` <br>e.g., `add n/James Ho p/22224444e/jamesho@example.com a/123, Clementi Rd, 1234665`
**Delete Participant** | `delete INDEX`<br> e.g., `delete 3`
**Edit Participant** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS]`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find Participant** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List Participants** | `list`
**View Participant details** | `view INDEX` <br> e.g., `view 1`
**Add Event** | `addEvent n/NAME d/DATE [t/TIME]` <br> e.g., `addEvent n/CS2100 Finals d/2021-11-20 t/0900`
**Delete Event** | `deleteEvent INDEX`  <br> e.g., `deleteEvent 1`
**Edit Event** | `editEvent INDEX [n/EVENT_NAME] [d/EVENT_DATE] [t/EVENT_TIME]` <br> e.g., `editEvent n/241Km Marathon`
**Mark an Event as done** | `done INDEX` <br> e.g., `done 1`
**Find Event** | `findEvent KEYWORD [MORE_KEYWORDS]`<br> e.g., `findEvent Marathon Commencement`
**Filter Events** | `filterEvents d/DATE [t/TIME]` <br> e.g., `filterEvents d/2021-09-18`
**Sort Events** | `sortEvents`
**List Events** | `listEvents`
**Show Event Details** | `showDetails INDEX` <br> e.g., `showDetails 1`
**Show Event Participants** | `showParticipants INDEX` <br> e.g., `showParticipants 3`
**Add Participant to Event** | `enroll INDEX_1 INDEX_2` <br> e.g. `enroll 1 2`
**Remove Participant from Event** | `expel INDEX_1 INDEX_2` <br> e.g. `expel 3 1`
**Help** | `help`
**Clear** | `clear`
**Exit** | `exit`
