     D COUNT           S              8  0 INZ(5)
     D FINAL           S              8  0 INZ(10)
     C                   EXSR      SR1
   
     **********************************************************************
     C                   SETON                                          LR
     **********************************************************************
     C     SR1           BEGSR
     C                   FOR       COUNT = 1 TO FINAL
     C                   DSPLY                   COUNT 
     C                   ENDFOR
     C                   ENDSR