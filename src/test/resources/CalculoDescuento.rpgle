     D Costo           S              8  0 INZ(0)
     D Precio          S              8  0 INZ(0)
     D PorDes          S              8  0 INZ(0)
     D MonDesc         S              8  0 INZ(0)
     C     *entry        plist
     C                   parm                    Costo                          I
     C                   parm                    Precio                         I
     C                   parm                    PorDes                         I
     C                   parm                    MonDesc                        I
     C                   clear                   dsp              50
     C                   EVAL      MonDesc = Precio / PorDes                        
     C                   IF        MonDesc > (Costo-Precio)
     C                   EVAL      dsp='El descuento supera el precio'
     C                   ELSE
     C                   EVAL      dsp='El monto del descuento es' +
     C                             %CHAR(MonDesc)
     C                   ENDIF
     C                   dsply                   dsp
     C                   seton                                        LR
     
     