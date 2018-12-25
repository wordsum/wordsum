# wordsum

### Purpose

**wordsum** is tool and a model that inputs English from a text file into hierarchical data model called a **FileState**.

The hierarchical model **FileState** branches to **ParagraphState** models, and a **ParagraphState** model branches to **SentenceStates** models.  
And a **SentenceState** branches into **NarrativeState** models.
 
wordsum models text from **FileState** to **NarrativeState** with end point */wordsum/filestate*

wordsum adds NLP tagging for all **NarrativeState** of a **FileState** with the endpoint */wordsum/filesate/nlpstate*

Please read the applications Swagger *http://localhost:9090/api/wordsum/swagger-ui.html* site for endpoint defintion and a manual testing GUI interface.

wordsum models for **PunctuationState**, **TenseState**, **NarratorState** and **PerspectiveState** of ***FileState** 
are under development.

These models of words are free and open source given the copyright at the end of this file.

### Requirements

Java 1.8 and gradle are the primary requirements. All other requiremnts are defined in the build.gradle
file and related files. 

### Building

*./gradlew bootJar*

### Testing

#### Unit Testing

*./gradlew testng*

*./gradlew test*

#### E2E Testing

1. *./gradlew bootRun*

2. Navigate in browser to: *http://localhost:9090/api/wordsum/swagger-ui.html*

3. Test */api/wordsum/filestate* by using Swagger UI and the file *src/text/resources/BabaYagaSneakAttack.txt* to test *file-state-controller*.

4. Test */api/wordsum/filestate/nlpstate* by using Swagger UI and the copied output from *file-state-controller* test.

### Copyright

  Open Story License

  Story: wordsum
  Writer: Kalab J. Oster&trade;
  Copyright Holders: Kalab J. Oster&trade;
  copyright &copy; 2018 Kalab J. Oster&trade;

  Permission is granted by the Copyright Holders for humans or other intelligent agents to read, write, edit, publish
  and critique the Story if the humans or intelligent agents keep this Open Story License with the Story,
  and if another writer writes or edits the Story then the writer's name needs to be appended to the end of the Writer
  list of this Open Story License.


