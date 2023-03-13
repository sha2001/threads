
### test
```mermaid
  graph LR;
      Delegator-->FileReader_EN-TEXT--> WordCounter_EN-->Writer;
      Delegator-->FileReader_ES-TEXT--> WordCounter_ES-->Writer; 
      Delegator-->FileReader_FR-TEXT--> WordCounter_FR-->Writer;
      Delegator-->FileReader_IT-TEXT--> WordCounter_IT-->Writer
```
