     D RESULT          S              8  0 INZ(5)
     D FINAL           S              8  0 INZ(0)
     C                   EXSR      SR1
   
     **********************************************************************
     C                   SETON                                          LR
     **********************************************************************
     C     SR1           BEGSR
     C                   DOW       FINAL < 10
     C                   EVAL      FINAL = FINAL + 1
     C                   DSPLY                   FINAL
     C                   ENDDO
     C                   ENDSR 