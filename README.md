
# ToDO App
<a href="https://i.ibb.co/j4D4yVM/register.png" width="200" height="200"><img src="https://i.ibb.co/j4D4yVM/register.png " width="200" height="200" title="ToDo" alt="ToDo"></a>




> A ToDo app for Component 2

> An app which can create and store task as well as give users ability to set dates reminders about their day to day activity

> tags: app, todo, android, github
---

## Table of Contents
### Click here to jump to these pages:-
- [Branching Stages](#branching-stages)
- [Architecture](#architecture)
- [Installation](#installation)
- [Project Pictures & GIFs](#gifs)
- [Documents](#documents)


---

# Branching Stages
```bash
├── Master
|
|---->|─ First Branch
│     ├── Fragment Branch
│     ├── Datepick Branch
│     ├── Timepick Branch
│     ├── Menubar Branch
│     ├── Login_register Branch 
│     ├── Layout Branch
│     ├── Design Branch
│     ├── About branch
│     ├── Logout Branch
│     ├── SpeechToText Branch
│     ├── 
│     ├── 

```

---
***Project Branches***

[![INSERT YOUR GRAPHIC HERE](https://i.ibb.co/N2VCLhq/Active.png)]()



---

# Architecture 
## Adapter
* `TabAdapter`<br>

## AddEditTask
* `AddEditTaskActivity`  <br>
* `AddEditTaskViewModel` <br>
* `AddEditTaskViewModelFactory` <br>
* `LoginFragments`<br>
* `RegisterFragments`<br>
* `SplashFragments`<br>
* `TodoListFormFragments`<br>
* `TodoListFragments`<br>

## Database
* `AppDatabase`  <br>
* `DateConverter` <br>
* `LoginDatabase` <br>
* `Repository` <br>
*  `RoomDAO` <br>
*  `TaskDao`<br>
*  `TaskEntry`<br>
*  `UsarenamePassword`<br>

## Tasks
* `ListFragment`  <br>
* `LoginActivity` <br>
* `MainActivity` <br>
* `MainActivityViewModel` <br>
*  `Register` <br>
*  `SecondFragment`<br>
*  `TaskAdapter`<br>

---




## Example of how the code looks

```java
// code away!

public class AddEditTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    Application application;
    int taskId;

    public AddEditTaskViewModelFactory(Application application, int taskId){
        this.application = application;
        this.taskId = taskId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return  (T) new AddEditTaskViewModel(application, taskId);
    }
}

```

---

## Installation

- First register an account by filling up the form
- After regestering Login with same details from registration page
- To add a task tap the floading 'Add' icon
- Fill in the fields with apropriate data
- After creation of new task tap anywhere on task to update
- To delete simply swipe the task left or right

### Clone

- Clone this repo to your local machine using `https://github.com/deepak-sen/ToDo_App`

### Setup

- If you want to edit the code:

> update and install these items

```shell
$ Android Studio
$ Latest Gradel
```

> Item needed to run code

```shell
$ Android Virtual Device
$ Android Phone running Android 5.5 or higher
```


---
## Pictures of various pages
Register          |  Sign-IN                      | Adding ToooDooo              
:----------------------------:|:--------------------------------------:|:----------------------:|
<img src = "https://i.ibb.co/9nmb67r/pic-login.png" width="288" height="512">  |  <img src = "https://i.ibb.co/cXsRzmJ/pic-task.png" width="288" height="512">        |  <img src = "https://i.ibb.co/ZmK7gnT/pictask.jpg" width="288" height="512">


---

## Gifs

> Gifs of various featurs of app

Register          |  LogIn                      | Add Task              |  Speech To Text
:----------------------------:|:--------------------------------------:|:----------------------:|:-----------------
<img src = "https://i.ibb.co/HzFTtLF/register.gif" width="200" height="360">  |  <img src = "https://i.ibb.co/Z1MJ77S/login.gif" width="200" height="360">        |  <img src = "https://i.ibb.co/nrfXR5W/addTask.gif" width="200" height="360">  | <img src = "https://i.ibb.co/FKNdTtt/speech.gif" width="200" height="360">
#
Update          |  CheckBox                      | Logout              |  Fragments
:----------------------------:|:--------------------------------------:|:----------------------:|:-----------------
<img src = "https://i.ibb.co/8KmR2Nr/update.gif" width="200" height="360">  |  <img src = "https://i.ibb.co/p4YWh75/checkbox.gif" width="200" height="360">        |  <img src = "https://i.ibb.co/3rVgQ5g/logout.gif" width="200" height="360">  | <img src = "https://i.ibb.co/LhLzwX0/fragments.gif" width="200" height="360">

---


# Documents
## MVVM 
<p align="center">
<img src="https://i.ibb.co/x6CRfgY/mvvm.png" alt="" width="500" height="500">
</p>
- MVVM stands for Model, View, ViewModel.

<p>-Model: This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables.</p>
<p>- View: It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.</p>
<p>- ViewModel: It acts as a link between the Model and the View. It’s responsible for transforming the data from the Model. It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model.</p>

---
# `References`

1. Fragments: [https://developer.android.com/guide/components/fragments]
2. Using Recyclerview: [https://developer.android.com/jetpack/androidx/releases/recyclerview]
3. Using Menus :[https://developer.android.com/guide/topics/ui/menus]
4. Intents and Intent Filters : [https://developer.android.com/guide/components/intents-filters]
5. Using Swipe: [https://developer.android.com/guide/navigation/navigation-swipe-view]
6. Room Persistence Library : [https://developer.android.com/topic/libraries/architecture/room]
7. MVVM architecture, ViewModel and LiveData : [https://proandroiddev.com/mvvm-architecture-viewmodel-and-livedata-part-1-604f50cda1]
8. ViewModel : [https://developer.android.com/reference/android/arch/lifecycle/ViewModel]


---

- Copyright 2020 © <a href="http://deepaksen.com.np" target="_blank">Deepak Sen</a>.
