public TerminalNode metron_f8415_0()
{    return getToken(StellarParser.DIV, 0);}
public void metron_f8416_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterArithExpr_div(this);}
public void metron_f8417_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitArithExpr_div(this);}
public Arithmetic_operandsContext metron_f8418_0()
{    return getRuleContext(Arithmetic_operandsContext.class, 0);}
public void metron_f8419_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterArithExpr_mul_solo(this);}
public void metron_f8420_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitArithExpr_mul_solo(this);}
public List<Arithmetic_expr_mulContext> metron_f8421_0()
{    return getRuleContexts(Arithmetic_expr_mulContext.class);}
public Arithmetic_expr_mulContext metron_f8422_0(int i)
{    return getRuleContext(Arithmetic_expr_mulContext.class, i);}
public TerminalNode metron_f8423_0()
{    return getToken(StellarParser.MUL, 0);}
public void metron_f8424_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterArithExpr_mul(this);}
public void metron_f8425_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitArithExpr_mul(this);}
public final Arithmetic_expr_mulContext metron_f8426_0() throws RecognitionException
{    return arithmetic_expr_mul(0);}
private Arithmetic_expr_mulContext metron_f8427_0(int _p) throws RecognitionException
{    ParserRuleContext _parentctx = _ctx;    int _parentState = getState();    Arithmetic_expr_mulContext _localctx = new Arithmetic_expr_mulContext(_ctx, _parentState);    Arithmetic_expr_mulContext _prevctx = _localctx;    int _startState = 36;    enterRecursionRule(_localctx, 36, RULE_arithmetic_expr_mul, _p);    try {        int _alt;        enterOuterAlt(_localctx, 1);        {            {                _localctx = new ArithExpr_mul_soloContext(_localctx);                _ctx = _localctx;                _prevctx = _localctx;                setState(241);                arithmetic_operands();            }            _ctx.stop = _input.LT(-1);            setState(251);            _errHandler.sync(this);            _alt = getInterpreter().adaptivePredict(_input, 19, _ctx);            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {                if (_alt == 1) {                    if (_parseListeners != null)                        triggerExitRuleEvent();                    _prevctx = _localctx;                    {                        setState(249);                        switch(getInterpreter().adaptivePredict(_input, 18, _ctx)) {                            case 1:                                {                                    _localctx = new ArithExpr_mulContext(new Arithmetic_expr_mulContext(_parentctx, _parentState));                                    pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr_mul);                                    setState(243);                                    if (!(precpred(_ctx, 2)))                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");                                    setState(244);                                    match(MUL);                                    setState(245);                                    arithmetic_expr_mul(3);                                }                                break;                            case 2:                                {                                    _localctx = new ArithExpr_divContext(new Arithmetic_expr_mulContext(_parentctx, _parentState));                                    pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr_mul);                                    setState(246);                                    if (!(precpred(_ctx, 1)))                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");                                    setState(247);                                    match(DIV);                                    setState(248);                                    arithmetic_expr_mul(2);                                }                                break;                        }                    }                }                setState(253);                _errHandler.sync(this);                _alt = getInterpreter().adaptivePredict(_input, 19, _ctx);            }        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        unrollRecursionContexts(_parentctx);    }    return _localctx;}
public int metron_f8428_0()
{    return RULE_functions;}
public void metron_f8429_0(FunctionsContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f8430_0()
{    return getToken(StellarParser.IDENTIFIER, 0);}
public Func_argsContext metron_f8431_0()
{    return getRuleContext(Func_argsContext.class, 0);}
public void metron_f8432_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterTransformationFunc(this);}
public void metron_f8433_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitTransformationFunc(this);}
public final FunctionsContext metron_f8434_0() throws RecognitionException
{    FunctionsContext _localctx = new FunctionsContext(_ctx, getState());    enterRule(_localctx, 38, RULE_functions);    try {        _localctx = new TransformationFuncContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(254);            match(IDENTIFIER);            setState(255);            func_args();        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f8435_0()
{    return RULE_arithmetic_operands;}
public void metron_f8436_0(Arithmetic_operandsContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f8437_0()
{    return getToken(StellarParser.IDENTIFIER, 0);}
public void metron_f8438_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterVariable(this);}
public void metron_f8439_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitVariable(this);}
public FunctionsContext metron_f8440_0()
{    return getRuleContext(FunctionsContext.class, 0);}
public void metron_f8441_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterNumericFunctions(this);}
public void metron_f8442_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitNumericFunctions(this);}
public TerminalNode metron_f8443_0()
{    return getToken(StellarParser.LONG_LITERAL, 0);}
public void metron_f8444_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLongLiteral(this);}
public void metron_f8445_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLongLiteral(this);}
public TerminalNode metron_f8446_0()
{    return getToken(StellarParser.FLOAT_LITERAL, 0);}
public void metron_f8447_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterFloatLiteral(this);}
public void metron_f8448_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitFloatLiteral(this);}
public TerminalNode metron_f8449_0()
{    return getToken(StellarParser.LPAREN, 0);}
public Conditional_exprContext metron_f8450_0()
{    return getRuleContext(Conditional_exprContext.class, 0);}
public TerminalNode metron_f8451_0()
{    return getToken(StellarParser.RPAREN, 0);}
public void metron_f8452_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterCondExpr(this);}
public void metron_f8453_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitCondExpr(this);}
public TerminalNode metron_f8454_0()
{    return getToken(StellarParser.LPAREN, 0);}
public Arithmetic_exprContext metron_f8455_0()
{    return getRuleContext(Arithmetic_exprContext.class, 0);}
public TerminalNode metron_f8456_0()
{    return getToken(StellarParser.RPAREN, 0);}
public void metron_f8457_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterParenArith(this);}
public void metron_f8458_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitParenArith(this);}
public TerminalNode metron_f8459_0()
{    return getToken(StellarParser.INT_LITERAL, 0);}
public void metron_f8460_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterIntLiteral(this);}
public void metron_f8461_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitIntLiteral(this);}
public TerminalNode metron_f8462_0()
{    return getToken(StellarParser.NAN, 0);}
public void metron_f8463_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterNaNArith(this);}
public void metron_f8464_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitNaNArith(this);}
public TerminalNode metron_f8465_0()
{    return getToken(StellarParser.DOUBLE_LITERAL, 0);}
public void metron_f8466_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterDoubleLiteral(this);}
public void metron_f8467_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitDoubleLiteral(this);}
public final Arithmetic_operandsContext metron_f8468_0() throws RecognitionException
{    Arithmetic_operandsContext _localctx = new Arithmetic_operandsContext(_ctx, getState());    enterRule(_localctx, 40, RULE_arithmetic_operands);    try {        setState(272);        switch(getInterpreter().adaptivePredict(_input, 20, _ctx)) {            case 1:                _localctx = new NumericFunctionsContext(_localctx);                enterOuterAlt(_localctx, 1);                {                    setState(257);                    functions();                }                break;            case 2:                _localctx = new DoubleLiteralContext(_localctx);                enterOuterAlt(_localctx, 2);                {                    setState(258);                    match(DOUBLE_LITERAL);                }                break;            case 3:                _localctx = new IntLiteralContext(_localctx);                enterOuterAlt(_localctx, 3);                {                    setState(259);                    match(INT_LITERAL);                }                break;            case 4:                _localctx = new LongLiteralContext(_localctx);                enterOuterAlt(_localctx, 4);                {                    setState(260);                    match(LONG_LITERAL);                }                break;            case 5:                _localctx = new FloatLiteralContext(_localctx);                enterOuterAlt(_localctx, 5);                {                    setState(261);                    match(FLOAT_LITERAL);                }                break;            case 6:                _localctx = new VariableContext(_localctx);                enterOuterAlt(_localctx, 6);                {                    setState(262);                    match(IDENTIFIER);                }                break;            case 7:                _localctx = new NaNArithContext(_localctx);                enterOuterAlt(_localctx, 7);                {                    setState(263);                    match(NAN);                }                break;            case 8:                _localctx = new ParenArithContext(_localctx);                enterOuterAlt(_localctx, 8);                {                    setState(264);                    match(LPAREN);                    setState(265);                    arithmetic_expr(0);                    setState(266);                    match(RPAREN);                }                break;            case 9:                _localctx = new CondExprContext(_localctx);                enterOuterAlt(_localctx, 9);                {                    setState(268);                    match(LPAREN);                    setState(269);                    conditional_expr();                    setState(270);                    match(RPAREN);                }                break;        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f8469_0()
{    return RULE_identifier_operand;}
public void metron_f8470_0(Identifier_operandContext ctx)
{    super.copyFrom(ctx);}
public Arithmetic_exprContext metron_f8471_0()
{    return getRuleContext(Arithmetic_exprContext.class, 0);}
public void metron_f8472_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterArithmeticOperands(this);}
public void metron_f8473_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitArithmeticOperands(this);}
public Lambda_with_argsContext metron_f8474_0()
{    return getRuleContext(Lambda_with_argsContext.class, 0);}
public void metron_f8475_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLambdaWithArgsExpr(this);}
public void metron_f8476_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLambdaWithArgsExpr(this);}
public TerminalNode metron_f8477_0()
{    return getToken(StellarParser.STRING_LITERAL, 0);}
public void metron_f8478_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterStringLiteral(this);}
public void metron_f8479_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitStringLiteral(this);}
public FunctionsContext metron_f8480_0()
{    return getRuleContext(FunctionsContext.class, 0);}
public void metron_f8481_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterFunc(this);}
public void metron_f8482_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitFunc(this);}
public Lambda_without_argsContext metron_f8483_0()
{    return getRuleContext(Lambda_without_argsContext.class, 0);}
public void metron_f8484_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLambdaWithoutArgsExpr(this);}
public void metron_f8485_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLambdaWithoutArgsExpr(this);}
public List_entityContext metron_f8486_0()
{    return getRuleContext(List_entityContext.class, 0);}
public void metron_f8487_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterList(this);}
public void metron_f8488_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitList(this);}
public Map_entityContext metron_f8489_0()
{    return getRuleContext(Map_entityContext.class, 0);}
public void metron_f8490_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterMapConst(this);}
public void metron_f8491_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitMapConst(this);}
public TerminalNode metron_f8492_0()
{    return getToken(StellarParser.TRUE, 0);}
public TerminalNode metron_f8493_0()
{    return getToken(StellarParser.FALSE, 0);}
public void metron_f8494_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLogicalConst(this);}
public void metron_f8495_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLogicalConst(this);}
public TerminalNode metron_f8496_0()
{    return getToken(StellarParser.NULL, 0);}
public void metron_f8497_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterNullConst(this);}
public void metron_f8498_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitNullConst(this);}
public TerminalNode metron_f8499_0()
{    return getToken(StellarParser.EXISTS, 0);}
public TerminalNode metron_f8500_0()
{    return getToken(StellarParser.LPAREN, 0);}
public TerminalNode metron_f8501_0()
{    return getToken(StellarParser.IDENTIFIER, 0);}
public TerminalNode metron_f8502_0()
{    return getToken(StellarParser.RPAREN, 0);}
public void metron_f8503_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterExistsFunc(this);}
public void metron_f8504_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitExistsFunc(this);}
public TerminalNode metron_f8505_0()
{    return getToken(StellarParser.LPAREN, 0);}
public Conditional_exprContext metron_f8506_0()
{    return getRuleContext(Conditional_exprContext.class, 0);}
public TerminalNode metron_f8507_0()
{    return getToken(StellarParser.RPAREN, 0);}
public void metron_f8508_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterCondExpr_paren(this);}
public void metron_f8509_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitCondExpr_paren(this);}
public final Identifier_operandContext metron_f8510_0() throws RecognitionException
{    Identifier_operandContext _localctx = new Identifier_operandContext(_ctx, getState());    enterRule(_localctx, 42, RULE_identifier_operand);    int _la;    try {        setState(291);        switch(getInterpreter().adaptivePredict(_input, 21, _ctx)) {            case 1:                _localctx = new LogicalConstContext(_localctx);                enterOuterAlt(_localctx, 1);                {                    setState(274);                    _la = _input.LA(1);                    if (!(_la == TRUE || _la == FALSE)) {                        _errHandler.recoverInline(this);                    } else {                        consume();                    }                }                break;            case 2:                _localctx = new LambdaWithArgsExprContext(_localctx);                enterOuterAlt(_localctx, 2);                {                    setState(275);                    lambda_with_args();                }                break;            case 3:                _localctx = new LambdaWithoutArgsExprContext(_localctx);                enterOuterAlt(_localctx, 3);                {                    setState(276);                    lambda_without_args();                }                break;            case 4:                _localctx = new ArithmeticOperandsContext(_localctx);                enterOuterAlt(_localctx, 4);                {                    setState(277);                    arithmetic_expr(0);                }                break;            case 5:                _localctx = new StringLiteralContext(_localctx);                enterOuterAlt(_localctx, 5);                {                    setState(278);                    match(STRING_LITERAL);                }                break;            case 6:                _localctx = new ListContext(_localctx);                enterOuterAlt(_localctx, 6);                {                    setState(279);                    list_entity();                }                break;            case 7:                _localctx = new MapConstContext(_localctx);                enterOuterAlt(_localctx, 7);                {                    setState(280);                    map_entity();                }                break;            case 8:                _localctx = new NullConstContext(_localctx);                enterOuterAlt(_localctx, 8);                {                    setState(281);                    match(NULL);                }                break;            case 9:                _localctx = new ExistsFuncContext(_localctx);                enterOuterAlt(_localctx, 9);                {                    setState(282);                    match(EXISTS);                    setState(283);                    match(LPAREN);                    setState(284);                    match(IDENTIFIER);                    setState(285);                    match(RPAREN);                }                break;            case 10:                _localctx = new CondExpr_parenContext(_localctx);                enterOuterAlt(_localctx, 10);                {                    setState(286);                    match(LPAREN);                    setState(287);                    conditional_expr();                    setState(288);                    match(RPAREN);                }                break;            case 11:                _localctx = new FuncContext(_localctx);                enterOuterAlt(_localctx, 11);                {                    setState(290);                    functions();                }                break;        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f8511_0()
{    return RULE_default_operand;}
public void metron_f8512_0(Default_operandContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f8513_0()
{    return getToken(StellarParser.DEFAULT, 0);}
public void metron_f8514_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterDefault(this);}
public void metron_f8515_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitDefault(this);}
public final Default_operandContext metron_f8516_0() throws RecognitionException
{    Default_operandContext _localctx = new Default_operandContext(_ctx, getState());    enterRule(_localctx, 44, RULE_default_operand);    try {        _localctx = new DefaultContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(293);            match(DEFAULT);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public TerminalNode metron_f8517_0()
{    return getToken(StellarParser.LPAREN, 0);}
public TerminalNode metron_f8518_0()
{    return getToken(StellarParser.RPAREN, 0);}
public TerminalNode metron_f8519_0()
{    return getToken(StellarParser.LAMBDA_OP, 0);}
public Transformation_exprContext metron_f8520_0()
{    return getRuleContext(Transformation_exprContext.class, 0);}
public int metron_f8521_0()
{    return RULE_lambda_without_args;}
public void metron_f8522_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLambda_without_args(this);}
public void metron_f8523_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLambda_without_args(this);}
public final Lambda_without_argsContext metron_f8524_0() throws RecognitionException
{    Lambda_without_argsContext _localctx = new Lambda_without_argsContext(_ctx, getState());    enterRule(_localctx, 46, RULE_lambda_without_args);    try {        enterOuterAlt(_localctx, 1);        {            setState(295);            match(LPAREN);            setState(296);            match(RPAREN);            setState(297);            match(LAMBDA_OP);            setState(298);            transformation_expr();        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public TerminalNode metron_f8525_0()
{    return getToken(StellarParser.LPAREN, 0);}
public Lambda_variablesContext metron_f8526_0()
{    return getRuleContext(Lambda_variablesContext.class, 0);}
public TerminalNode metron_f8527_0()
{    return getToken(StellarParser.RPAREN, 0);}
public TerminalNode metron_f8528_0()
{    return getToken(StellarParser.LAMBDA_OP, 0);}
public Transformation_exprContext metron_f8529_0()
{    return getRuleContext(Transformation_exprContext.class, 0);}
public Single_lambda_variableContext metron_f8530_0()
{    return getRuleContext(Single_lambda_variableContext.class, 0);}
public int metron_f8531_0()
{    return RULE_lambda_with_args;}
public void metron_f8532_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLambda_with_args(this);}
public void metron_f8533_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLambda_with_args(this);}
public final Lambda_with_argsContext metron_f8534_0() throws RecognitionException
{    Lambda_with_argsContext _localctx = new Lambda_with_argsContext(_ctx, getState());    enterRule(_localctx, 48, RULE_lambda_with_args);    try {        setState(310);        switch(_input.LA(1)) {            case LPAREN:                enterOuterAlt(_localctx, 1);                {                    setState(300);                    match(LPAREN);                    setState(301);                    lambda_variables();                    setState(302);                    match(RPAREN);                    setState(303);                    match(LAMBDA_OP);                    setState(304);                    transformation_expr();                }                break;            case IDENTIFIER:                enterOuterAlt(_localctx, 2);                {                    setState(306);                    single_lambda_variable();                    setState(307);                    match(LAMBDA_OP);                    setState(308);                    transformation_expr();                }                break;            default:                throw new NoViableAltException(this);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public List<Lambda_variableContext> metron_f8535_0()
{    return getRuleContexts(Lambda_variableContext.class);}
public Lambda_variableContext metron_f8536_0(int i)
{    return getRuleContext(Lambda_variableContext.class, i);}
public List<TerminalNode> metron_f8537_0()
{    return getTokens(StellarParser.COMMA);}
public TerminalNode metron_f8538_0(int i)
{    return getToken(StellarParser.COMMA, i);}
public int metron_f8539_0()
{    return RULE_lambda_variables;}
public void metron_f8540_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLambda_variables(this);}
public void metron_f8541_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLambda_variables(this);}
public final Lambda_variablesContext metron_f8542_0() throws RecognitionException
{    Lambda_variablesContext _localctx = new Lambda_variablesContext(_ctx, getState());    enterRule(_localctx, 50, RULE_lambda_variables);    int _la;    try {        enterOuterAlt(_localctx, 1);        {            setState(312);            lambda_variable();            setState(317);            _errHandler.sync(this);            _la = _input.LA(1);            while (_la == COMMA) {                {                    {                        setState(313);                        match(COMMA);                        setState(314);                        lambda_variable();                    }                }                setState(319);                _errHandler.sync(this);                _la = _input.LA(1);            }        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public Lambda_variableContext metron_f8543_0()
{    return getRuleContext(Lambda_variableContext.class, 0);}
public int metron_f8544_0()
{    return RULE_single_lambda_variable;}
public void metron_f8545_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterSingle_lambda_variable(this);}
public void metron_f8546_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitSingle_lambda_variable(this);}
public final Single_lambda_variableContext metron_f8547_0() throws RecognitionException
{    Single_lambda_variableContext _localctx = new Single_lambda_variableContext(_ctx, getState());    enterRule(_localctx, 52, RULE_single_lambda_variable);    try {        enterOuterAlt(_localctx, 1);        {            setState(320);            lambda_variable();        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public TerminalNode metron_f8548_0()
{    return getToken(StellarParser.IDENTIFIER, 0);}
public int metron_f8549_0()
{    return RULE_lambda_variable;}
public void metron_f8550_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterLambda_variable(this);}
public void metron_f8551_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitLambda_variable(this);}
public final Lambda_variableContext metron_f8552_0() throws RecognitionException
{    Lambda_variableContext _localctx = new Lambda_variableContext(_ctx, getState());    enterRule(_localctx, 54, RULE_lambda_variable);    try {        enterOuterAlt(_localctx, 1);        {            setState(322);            match(IDENTIFIER);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f8553_0()
{    return RULE_match_expr;}
public void metron_f8554_0(Match_exprContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f8555_0()
{    return getToken(StellarParser.MATCH, 0);}
public TerminalNode metron_f8556_0()
{    return getToken(StellarParser.LBRACE, 0);}
public Match_clausesContext metron_f8557_0()
{    return getRuleContext(Match_clausesContext.class, 0);}
public TerminalNode metron_f8558_0()
{    return getToken(StellarParser.COMMA, 0);}
public TerminalNode metron_f8559_0()
{    return getToken(StellarParser.DEFAULT, 0);}
public TerminalNode metron_f8560_0()
{    return getToken(StellarParser.MATCH_ACTION, 0);}
public Match_clause_actionContext metron_f8561_0()
{    return getRuleContext(Match_clause_actionContext.class, 0);}
public TerminalNode metron_f8562_0()
{    return getToken(StellarParser.RBRACE, 0);}
public void metron_f8563_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterMatchClauses(this);}
public void metron_f8564_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitMatchClauses(this);}
public final Match_exprContext metron_f8565_0() throws RecognitionException
{    Match_exprContext _localctx = new Match_exprContext(_ctx, getState());    enterRule(_localctx, 56, RULE_match_expr);    try {        _localctx = new MatchClausesContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(324);            match(MATCH);            setState(325);            match(LBRACE);            setState(326);            match_clauses();            setState(327);            match(COMMA);            setState(328);            match(DEFAULT);            setState(329);            match(MATCH_ACTION);            setState(330);            match_clause_action();            setState(331);            match(RBRACE);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public List<Match_clauseContext> metron_f8566_0()
{    return getRuleContexts(Match_clauseContext.class);}
public Match_clauseContext metron_f8567_0(int i)
{    return getRuleContext(Match_clauseContext.class, i);}
public List<TerminalNode> metron_f8568_0()
{    return getTokens(StellarParser.COMMA);}
public TerminalNode metron_f8569_0(int i)
{    return getToken(StellarParser.COMMA, i);}
public int metron_f8570_0()
{    return RULE_match_clauses;}
public void metron_f8571_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterMatch_clauses(this);}
public void metron_f8572_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitMatch_clauses(this);}
public final Match_clausesContext metron_f8573_0() throws RecognitionException
{    Match_clausesContext _localctx = new Match_clausesContext(_ctx, getState());    enterRule(_localctx, 58, RULE_match_clauses);    try {        int _alt;        enterOuterAlt(_localctx, 1);        {            setState(333);            match_clause();            setState(338);            _errHandler.sync(this);            _alt = getInterpreter().adaptivePredict(_input, 24, _ctx);            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {                if (_alt == 1) {                    {                        {                            setState(334);                            match(COMMA);                            setState(335);                            match_clause();                        }                    }                }                setState(340);                _errHandler.sync(this);                _alt = getInterpreter().adaptivePredict(_input, 24, _ctx);            }        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public Match_clause_checkContext metron_f8574_0()
{    return getRuleContext(Match_clause_checkContext.class, 0);}
public TerminalNode metron_f8575_0()
{    return getToken(StellarParser.MATCH_ACTION, 0);}
public Match_clause_actionContext metron_f8576_0()
{    return getRuleContext(Match_clause_actionContext.class, 0);}
public int metron_f8577_0()
{    return RULE_match_clause;}
public void metron_f8578_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterMatch_clause(this);}
public void metron_f8579_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitMatch_clause(this);}
public final Match_clauseContext metron_f8580_0() throws RecognitionException
{    Match_clauseContext _localctx = new Match_clauseContext(_ctx, getState());    enterRule(_localctx, 60, RULE_match_clause);    try {        enterOuterAlt(_localctx, 1);        {            setState(341);            match_clause_check();            setState(342);            match(MATCH_ACTION);            setState(343);            match_clause_action();        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f8581_0()
{    return RULE_match_clause_action;}
public void metron_f8582_0(Match_clause_actionContext ctx)
{    super.copyFrom(ctx);}
public Transformation_exprContext metron_f8583_0()
{    return getRuleContext(Transformation_exprContext.class, 0);}
public void metron_f8584_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterMatchClauseAction(this);}
public void metron_f8585_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitMatchClauseAction(this);}
public final Match_clause_actionContext metron_f8586_0() throws RecognitionException
{    Match_clause_actionContext _localctx = new Match_clause_actionContext(_ctx, getState());    enterRule(_localctx, 62, RULE_match_clause_action);    try {        _localctx = new MatchClauseActionContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(345);            transformation_expr();        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f8587_0()
{    return RULE_match_clause_check;}
public void metron_f8588_0(Match_clause_checkContext ctx)
{    super.copyFrom(ctx);}
public Logical_exprContext metron_f8589_0()
{    return getRuleContext(Logical_exprContext.class, 0);}
public Conditional_exprContext metron_f8590_0()
{    return getRuleContext(Conditional_exprContext.class, 0);}
public void metron_f8591_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).enterMatchClauseCheckExpr(this);}
public void metron_f8592_0(ParseTreeListener listener)
{    if (listener instanceof StellarListener)        ((StellarListener) listener).exitMatchClauseCheckExpr(this);}
public final Match_clause_checkContext metron_f8593_0() throws RecognitionException
{    Match_clause_checkContext _localctx = new Match_clause_checkContext(_ctx, getState());    enterRule(_localctx, 64, RULE_match_clause_check);    try {        setState(349);        switch(getInterpreter().adaptivePredict(_input, 25, _ctx)) {            case 1:                _localctx = new MatchClauseCheckExprContext(_localctx);                enterOuterAlt(_localctx, 1);                {                    setState(347);                    logical_expr();                }                break;            case 2:                _localctx = new MatchClauseCheckExprContext(_localctx);                enterOuterAlt(_localctx, 2);                {                    setState(348);                    conditional_expr();                }                break;        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public boolean metron_f8594_0(RuleContext _localctx, int ruleIndex, int predIndex)
{    switch(ruleIndex) {        case 9:            return comparison_expr_sempred((Comparison_exprContext) _localctx, predIndex);        case 13:            return op_list_sempred((Op_listContext) _localctx, predIndex);        case 15:            return kv_list_sempred((Kv_listContext) _localctx, predIndex);        case 17:            return arithmetic_expr_sempred((Arithmetic_exprContext) _localctx, predIndex);        case 18:            return arithmetic_expr_mul_sempred((Arithmetic_expr_mulContext) _localctx, predIndex);    }    return true;}
private boolean metron_f8595_0(Comparison_exprContext _localctx, int predIndex)
{    switch(predIndex) {        case 0:            return precpred(_ctx, 4);    }    return true;}
private boolean metron_f8596_0(Op_listContext _localctx, int predIndex)
{    switch(predIndex) {        case 1:            return precpred(_ctx, 5);        case 2:            return precpred(_ctx, 3);        case 3:            return precpred(_ctx, 1);    }    return true;}
private boolean metron_f8597_0(Kv_listContext _localctx, int predIndex)
{    switch(predIndex) {        case 4:            return precpred(_ctx, 2);        case 5:            return precpred(_ctx, 1);    }    return true;}
private boolean metron_f8598_0(Arithmetic_exprContext _localctx, int predIndex)
{    switch(predIndex) {        case 6:            return precpred(_ctx, 2);        case 7:            return precpred(_ctx, 1);    }    return true;}
private boolean metron_f8599_0(Arithmetic_expr_mulContext _localctx, int predIndex)
{    switch(predIndex) {        case 8:            return precpred(_ctx, 2);        case 9:            return precpred(_ctx, 1);    }    return true;}
public Deque<Token<?>> metron_f8600_0()
{    Deque<Token<?>> ret = new ArrayDeque<>(super.getTokenDeque().size());    for (Token<?> token : super.getTokenDeque()) {        ret.add(token);    }    return ret;}
public Object metron_f8601_0(List<Object> variableArgs)
{    Map<String, Object> lambdaVariables = new HashMap<>();    int i = 0;    for (; i < Math.min(variables.size(), variableArgs.size()); ++i) {        lambdaVariables.put(variables.get(i), variableArgs.get(i));    }    for (; i < variables.size(); ++i) {        lambdaVariables.put(variables.get(i), null);    }    VariableResolver variableResolver = new DefaultVariableResolver(variable -> lambdaVariables.getOrDefault(variable, state.variableResolver.resolve(variable)), variable -> true);    StellarCompiler.ExpressionState localState = new StellarCompiler.ExpressionState(state.context, state.functionResolver, variableResolver);    return apply(localState);}
public void metron_f8602_0()
{    paused.set(true);}
public void metron_f8603_0() throws IOException
{    paused.set(false);}
public int metron_f8604_0() throws IOException
{    if (paused.get()) {        try {            Thread.sleep(1000);        } catch (InterruptedException e) {            e.printStackTrace();        }        return 0;    }    return in.read();}
public int metron_f8605_0(byte[] b) throws IOException
{    if (paused.get()) {        try {            Thread.sleep(1000);        } catch (InterruptedException e) {            e.printStackTrace();        }        return 0;    }    int ret = in.read(b);    return ret;}
public int metron_f8606_0(byte[] b, int off, int len) throws IOException
{    if (paused.get()) {        try {            Thread.sleep(1000);        } catch (InterruptedException e) {            e.printStackTrace();        }        return 0;    }    int ret = in.read(b, off, len);    return ret;}
public long metron_f8607_0(long n) throws IOException
{    return in.skip(n);}
public int metron_f8608_0() throws IOException
{    return in.available();}
public void metron_f8609_0() throws IOException
{    in.close();}
public synchronized void metron_f8610_0(int readlimit)
{    in.mark(readlimit);}
public synchronized void metron_f8611_0() throws IOException
{    in.reset();}
public boolean metron_f8612_0()
{    return in.markSupported();}
public static void metron_f8613_0(String[] args) throws Exception
{    StellarShell shell = new StellarShell(args);    shell.run();}
private Options metron_f8614_0()
{    Options options = new Options();    options.addOption("z", "zookeeper", true, "Zookeeper URL fragment in the form [HOSTNAME|IPADDRESS]:PORT");    options.addOption("v", "variables", true, "File containing a JSON Map of variables");    options.addOption("irc", "inputrc", true, "File containing the inputrc if not the default ~/.inputrc");    options.addOption("na", "no_ansi", false, "Make the input prompt not use ANSI colors.");    options.addOption("h", "help", false, "Print help");    options.addOption("p", "properties", true, "File containing Stellar properties");    Option log4j = new Option("l", "log4j", true, "The log4j properties file to load");    log4j.setArgName("FILE");    log4j.setRequired(false);    options.addOption(log4j);    return options;}
private static void metron_f8615_0(CommandLine commandLine, StellarShellExecutor executor) throws IOException
{    if (commandLine.hasOption("v")) {                String variablePath = commandLine.getOptionValue("v");        Map<String, Object> variables = JSONUtils.INSTANCE.load(new File(variablePath), JSONUtils.MAP_SUPPLIER);                for (Map.Entry<String, Object> kv : variables.entrySet()) {            String variable = kv.getKey();            Object value = kv.getValue();                        executor.assign(variable, value, Optional.empty());        }    }}
private StellarShellExecutor metron_f8616_0(CommandLine commandLine, Console console, Properties properties, StellarAutoCompleter autoCompleter) throws Exception
{        Optional<String> zookeeperUrl = Optional.empty();    if (commandLine.hasOption("z")) {        zookeeperUrl = Optional.of(commandLine.getOptionValue("z"));    }    StellarShellExecutor executor = new DefaultStellarShellExecutor(properties, zookeeperUrl);        executor.getContext().addCapability(CONSOLE, () -> console);        executor.getContext().addCapability(SHELL_VARIABLES, () -> executor.getState());        executor.addSpecialListener((special) -> autoCompleter.addCandidateFunction(special.getCommand()));    executor.addFunctionListener((function) -> autoCompleter.addCandidateFunction(function.getName()));    executor.addVariableListener((name, val) -> autoCompleter.addCandidateVariable(name));    executor.init();    return executor;}
private Console metron_f8617_0(CommandLine commandLine)
{        boolean useAnsi = !commandLine.hasOption("na");    SettingsBuilder settings = new SettingsBuilder().enableAlias(true).enableMan(true).ansi(useAnsi).parseOperators(false).inputStream(PausableInput.INSTANCE);    if (commandLine.hasOption("irc")) {        settings = settings.inputrc(new File(commandLine.getOptionValue("irc")));    }    return new Console(settings.create());}
private Properties metron_f8618_0(CommandLine commandLine) throws IOException
{    Properties properties = new Properties();    if (commandLine.hasOption("p")) {                try (InputStream in = new FileInputStream(commandLine.getOptionValue("p"))) {            if (in != null) {                properties.load(in);            }        }    } else {                try (InputStream in = getClass().getClassLoader().getResourceAsStream(STELLAR_PROPERTIES_FILENAME)) {            if (in != null) {                properties.load(in);            }        }    }    return properties;}
public void metron_f8619_0()
{        writeLine(WELCOME);        executor.getContext().getCapability(GLOBAL_CONFIG, false).ifPresent(conf -> writeLine(conf.toString()));    console.start();}
private void metron_f8620_0()
{    try {        console.stop();        StellarFunctions.close();    } catch (Throwable e) {        e.printStackTrace();    }}
private void metron_f8621_0(String out)
{    console.getShell().out().println(out);}
public int metron_f8622_0(ConsoleOperation output) throws InterruptedException
{        String expression = StringUtils.trimToEmpty(output.getBuffer());    if (StringUtils.isNotBlank(expression)) {                StellarResult result = executor.execute(expression);        if (result.isSuccess()) {                        result.getValue().ifPresent(v -> writeLine(v.toString()));        } else if (result.isError()) {                        result.getException().ifPresent(e -> writeLine(ERROR_PROMPT + e.getMessage()));            result.getException().ifPresent(e -> e.printStackTrace());        } else if (result.isTerminate()) {                        handleQuit();        } else {                        throw new IllegalStateException("An execution result is neither a success nor a failure. Please file a bug report.");        }    }    return 0;}
public void metron_f8623_0(CompleteOperation completeOperation)
{    String buffer = completeOperation.getBuffer();    final String lastToken = getLastToken(buffer);    Iterable<String> candidates = autoCompleter.autoComplete(buffer);        if (candidates != null && !Iterables.isEmpty(candidates)) {        for (String candidate : candidates) {            String completion = stripOff(buffer, lastToken) + candidate;            completeOperation.addCompletionCandidate(completion);        }    }}
private static String metron_f8624_0(String buffer)
{    String lastToken = Iterables.getLast(Splitter.on(" ").split(buffer), null);    return lastToken.trim();}
private static String metron_f8625_0(String baseString, String lastBit)
{    int index = baseString.lastIndexOf(lastBit);    if (index < 0) {        return baseString;    }    return baseString.substring(0, index);}
public StellarShellExecutor metron_f8626_0()
{    return executor;}
public Console metron_f8627_0()
{    return console;}
public static void metron_f8628_0(CommandLine commandLine) throws IllegalArgumentException
{    if (commandLine.hasOption('z')) {        validateZookeeperOption(commandLine.getOptionValue('z'));    }        if (commandLine.hasOption('v')) {        validateFileOption("v", commandLine.getOptionValue('v'));    }    if (commandLine.hasOption("irc")) {        validateFileOption("irc", commandLine.getOptionValue("irc"));    }    if (commandLine.hasOption('p')) {        validateFileOption("p", commandLine.getOptionValue('p'));    }}
private static void metron_f8629_0(String zMulti) throws IllegalArgumentException
{    for (String z : Splitter.on(",").split(zMulti)) {        Matcher matcher = validPortPattern.matcher(z);        boolean hasPort = z.contains(":");        if (hasPort && !matcher.matches()) {            throw new IllegalArgumentException(String.format("Zookeeper option must have valid port: %s", z));        }        if (hasPort && matcher.groupCount() != 2) {            throw new IllegalArgumentException(String.format("Zookeeper Option must be in the form of [HOST|IP]:PORT  %s", z));        }        String name = hasPort ? matcher.group(1) : z;        Integer port = hasPort ? Integer.parseInt(matcher.group(2)) : null;        if (!hostnameValidator.test(name) && !inetAddressValidator.isValid(name)) {            throw new IllegalArgumentException(String.format("Zookeeper Option %s is not a valid host name or ip address  %s", name, z));        }        if (hasPort && (port == 0 || port > 65535)) {            throw new IllegalArgumentException(String.format("Zookeeper Option %s port is not valid", z));        }    }}
private static void metron_f8630_0(String option, String fileName) throws IllegalArgumentException
{    File file = new File(fileName);    if (!file.exists()) {        throw new IllegalArgumentException(String.format("%s: File %s doesn't exist", option, fileName));    }    if (!file.canRead()) {        throw new IllegalArgumentException(String.format("%s: File %s is not readable", option, fileName));    }}
public String metron_f8631_0(OperationType type, String key)
{    return transform.transform(type, key);}
public Iterable<String> metron_f8632_0(String buffer)
{    Iterable<String> candidates = IterableUtils.emptyIterable();    final String lastToken = getLastToken(buffer);    if (StringUtils.isNotEmpty(lastToken)) {        if (isDoc(lastToken)) {            candidates = autoCompleteDoc(lastToken.substring(1));        } else if (isMagic(lastToken)) {            candidates = autoCompleteMagic(lastToken);        } else {            candidates = autoCompleteNormal(lastToken);        }    }    return candidates;}
private boolean metron_f8633_0(String expression)
{    return StringUtils.startsWith(expression, "%");}
private boolean metron_f8634_0(String expression)
{    return StringUtils.startsWith(expression, "?");}
private Iterable<String> metron_f8635_0(String buffer)
{    return autoComplete(buffer, OperationType.NORMAL);}
private Iterable<String> metron_f8636_0(String buffer)
{    return autoComplete(buffer, OperationType.DOC);}
private Iterable<String> metron_f8637_0(String buffer)
{    return autoComplete(buffer, OperationType.MAGIC);}
private Iterable<String> metron_f8638_0(String buffer, final OperationType opType)
{    indexLock.readLock().lock();    try {        SortedMap<String, AutoCompleteType> ret = autocompleteIndex.prefixMap(buffer);        if (ret.isEmpty()) {            return new ArrayList<>();        }        return Iterables.transform(ret.entrySet(), kv -> kv.getValue().transform(opType, kv.getKey()));    } finally {        indexLock.readLock().unlock();    }}
public void metron_f8639_0(String name)
{    add(name, AutoCompleteType.FUNCTION);}
public void metron_f8640_0(String name)
{    add(name, AutoCompleteType.VARIABLE);}
private void metron_f8641_0(String name, AutoCompleteType type)
{    if (StringUtils.isNotBlank(name)) {                indexLock.writeLock().lock();        try {            this.autocompleteIndex.put(name, type);        } finally {            indexLock.writeLock().unlock();        }    }}
private PatriciaTrie<AutoCompleteType> metron_f8642_0()
{    Map<String, AutoCompleteType> index = new HashMap<>();    index.put("==", AutoCompleteType.TOKEN);    index.put(">=", AutoCompleteType.TOKEN);    index.put("<=", AutoCompleteType.TOKEN);    return new PatriciaTrie<>(index);}
private static String metron_f8643_0(String buffer)
{    String lastToken = Iterables.getLast(Splitter.on(" ").split(buffer), null);    return lastToken.trim();}
public static List<SpecialCommand> metron_f8644_0()
{    return Arrays.asList(new AssignmentCommand(), new DocCommand(), new QuitCommand(), new Comment(), new MagicListFunctions(), new MagicListVariables(), new MagicDefineGlobal(), new MagicUndefineGlobal(), new MagicListGlobals());}
public void metron_f8645_0()
{    StellarFunctions.initialize(this.context);        for (SpecialCommand command : specials) {        notifySpecialListeners(command);    }        for (StellarFunctionInfo fn : functionResolver.getFunctionInfo()) {        notifyFunctionListeners(fn);    }}
public void metron_f8646_0(FunctionDefinedListener listener)
{    this.functionListeners.add(listener);}
private void metron_f8647_0(StellarFunctionInfo functionInfo)
{    for (FunctionDefinedListener listener : functionListeners) {        listener.whenFunctionDefined(functionInfo);    }}
public void metron_f8648_0(VariableDefinedListener listener)
{    this.variableListeners.add(listener);}
private void metron_f8649_0(String variableName, VariableResult result)
{    for (VariableDefinedListener listener : variableListeners) {        listener.whenVariableDefined(variableName, result);    }}
public void metron_f8650_0(SpecialDefinedListener listener)
{    this.specialListeners.add(listener);}
private void metron_f8651_0(SpecialCommand specialCommand)
{    for (SpecialDefinedListener listener : specialListeners) {        listener.whenSpecialDefined(specialCommand);    }}
public StellarResult metron_f8652_0(String expression)
{        expression = StringUtils.trimToEmpty(expression);    if (StringUtils.isBlank(expression)) {        return noop();    }        for (SpecialCommand command : specials) {        if (command.getMatcher().apply(expression)) {            return command.execute(expression, this);        }    }        return executeStellar(expression);}
public Map<String, Object> metron_f8653_0()
{    Map<String, Object> globals;    Optional<Object> capability = getContext().getCapability(GLOBAL_CONFIG, false);    if (capability.isPresent()) {        globals = (Map<String, Object>) capability.get();    } else {        throw new IllegalStateException("'GLOBAL_CONFIG' is missing");    }    return globals;}
public void metron_f8654_0(String variableName, Object value, Optional<String> expression)
{        VariableResult varResult = VariableResult.withExpression(value, expression);    this.variables.put(variableName, varResult);        notifyVariableListeners(variableName, varResult);}
public FunctionResolver metron_f8655_0()
{    return functionResolver;}
public Map<String, VariableResult> metron_f8656_0()
{    return UnmodifiableMap.decorate(variables);}
public Map<String, Object> metron_f8657_0()
{    return Maps.transformValues(variables, (v) -> v.getResult());}
public Context metron_f8658_0()
{    return context;}
private Map<String, Object> metron_f8661_0(CuratorFramework zkClient) throws Exception
{    byte[] raw = readGlobalConfigBytesFromZookeeper(zkClient);    return JSONUtils.INSTANCE.load(new ByteArrayInputStream(raw), JSONUtils.MAP_SUPPLIER);}
private Map<String, Object> metron_f8662_0(Map<String, Object> globalConfig, Properties props)
{    Map<String, Object> stellarConfig = new HashMap<>();    stellarConfig.putAll(globalConfig);    if (props != null) {        for (Map.Entry<Object, Object> kv : props.entrySet()) {            stellarConfig.put(kv.getKey().toString(), kv.getValue());        }    }    return stellarConfig;}
private StellarResult metron_f8663_0(String expression)
{    StellarResult result;    try {                VariableResolver variableResolver = new MapVariableResolver(getVariables());        Object exprResult = new StellarProcessor().parse(expression, variableResolver, functionResolver, context);        result = success(exprResult);    } catch (Throwable t) {        result = error(t);    }    return result;}
public Function<String, Boolean> metron_f8664_0()
{    return (input) -> StellarAssignment.isAssignment(input);}
public String metron_f8665_0()
{    return ASSIGNMENT_OP;}
public StellarResult metron_f8666_0(String input, StellarShellExecutor executor)
{    assert StellarAssignment.isAssignment(input);        StellarAssignment assignment = StellarAssignment.from(input);    String varName = assignment.getVariable();    String varExpr = assignment.getStatement();        StellarResult result = executor.execute(varExpr);    if (result.isSuccess()) {        Object value = null;        if (result.getValue().isPresent()) {            value = result.getValue().get();        } else if (result.isValueNull()) {            value = null;        }                executor.assign(varName, value, Optional.of(varExpr));        return result;    } else {        return result;    }}
public String metron_f8667_0()
{    return "#";}
public Function<String, Boolean> metron_f8668_0()
{    return (input) -> startsWith(trimToEmpty(input), COMMENT_PREFIX);}
public StellarResult metron_f8669_0(String expression, StellarShellExecutor executor)
{    return noop();}
public String metron_f8670_0()
{    return DOC_PREFIX;}
public Function<String, Boolean> metron_f8671_0()
{    return (input) -> StringUtils.startsWith(input, DOC_PREFIX);}
public StellarResult metron_f8672_0(String command, StellarShellExecutor executor)
{    StellarResult result;        String functionName = StringUtils.substring(command, 1);        Spliterator<StellarFunctionInfo> fnIterator = executor.getFunctionResolver().getFunctionInfo().spliterator();    Optional<StellarFunctionInfo> functionInfo = StreamSupport.stream(fnIterator, false).filter(info -> StringUtils.equals(functionName, info.getName())).findFirst();    if (functionInfo.isPresent()) {        result = success(docFormat(functionInfo.get()));    } else {        result = error(String.format("No docs available for function '%s'", functionName));    }    return result;}
private String metron_f8673_0(StellarFunctionInfo info)
{    StringBuffer docString = new StringBuffer();        docString.append(info.getName() + "\n");        docString.append(String.format("Description: %-60s\n\n", info.getDescription()));        if (info.getParams().length > 0) {        docString.append("Arguments:\n");        for (String param : info.getParams()) {            docString.append(String.format("\t%-60s\n", param));        }        docString.append("\n");    }        docString.append(String.format("Returns: %-60s\n", info.getReturns()));    return docString.toString();}
public String metron_f8674_0()
{    return MAGIC_DEFINE;}
public Function<String, Boolean> metron_f8675_0()
{    return (input) -> startsWith(trimToEmpty(input), MAGIC_DEFINE);}
public StellarResult metron_f8676_0(String command, StellarShellExecutor executor)
{        String assignExpr = StringUtils.trimToEmpty(command.substring(MAGIC_DEFINE.length()));    if (StringUtils.length(assignExpr) < 1) {        return error(MAGIC_DEFINE + " missing assignment expression");    }        if (!StellarAssignment.isAssignment(assignExpr)) {        return error(MAGIC_DEFINE + " expected assignment expression");    }        StellarAssignment expr = StellarAssignment.from(assignExpr);    StellarResult result = executor.execute(expr.getStatement());        if (!result.isSuccess()) {        return error(MAGIC_DEFINE + " expression execution failed");    }        if (!result.getValue().isPresent()) {        return error(MAGIC_DEFINE + " expression produced no result");    }        Object value = result.getValue().get();    executor.getGlobalConfig().put(expr.getVariable(), value);    return success(value);}
public String metron_f8677_0()
{    return MAGIC_FUNCTIONS;}
public Function<String, Boolean> metron_f8678_0()
{    return (input) -> startsWith(trimToEmpty(input), MAGIC_FUNCTIONS);}
public StellarResult metron_f8679_0(String command, StellarShellExecutor executor)
{        String startsWith = StringUtils.trimToEmpty(command.substring(MAGIC_FUNCTIONS.length()));    Predicate<String> nameFilter = (name -> true);    if (StringUtils.isNotBlank(startsWith)) {        nameFilter = (name -> name.contains(startsWith));    }        String functions = StreamSupport.stream(executor.getFunctionResolver().getFunctionInfo().spliterator(), false).map(info -> String.format("%s", info.getName())).filter(nameFilter).sorted().collect(Collectors.joining(", "));    return StellarResult.success(functions);}
public String metron_f8680_0()
{    return MAGIC_GLOBALS;}
public Function<String, Boolean> metron_f8681_0()
{    return (input) -> startsWith(trimToEmpty(input), MAGIC_GLOBALS);}
public StellarResult metron_f8682_0(String command, StellarShellExecutor executor)
{    Map<String, Object> globals = executor.getGlobalConfig();    return StellarResult.success(globals.toString());}
public String metron_f8683_0()
{    return MAGIC_VARS;}
public Function<String, Boolean> metron_f8684_0()
{    return (input) -> startsWith(trimToEmpty(input), MAGIC_VARS);}
public StellarResult metron_f8685_0(String command, StellarShellExecutor executor)
{        String vars = executor.getState().entrySet().stream().map(e -> format(e)).collect(Collectors.joining(", "));    return success(vars);}
private String metron_f8686_0(Map.Entry<String, VariableResult> var)
{        String out = String.format("%s = %s", var.getKey(), var.getValue().getResult());        if (var.getValue().getExpression().isPresent()) {        out += String.format(" via `%s`", var.getValue().getExpression().get());    }    return out;}
public String metron_f8687_0()
{    return MAGIC_UNDEFINE;}
public Function<String, Boolean> metron_f8688_0()
{    return (input) -> startsWith(trimToEmpty(input), MAGIC_UNDEFINE);}
public StellarResult metron_f8689_0(String command, StellarShellExecutor executor)
{    StellarResult result;    String variable = StringUtils.trimToEmpty(command.substring(MAGIC_UNDEFINE.length()));    if (StringUtils.isNotBlank(variable)) {                Map<String, Object> globals = executor.getGlobalConfig();        globals.remove(variable);        result = noop();    } else {        result = error(String.format("%s expected name of global, got '%s'", MAGIC_UNDEFINE, variable));    }    return result;}
public String metron_f8690_0()
{    return QUIT_COMMAND;}
public Function<String, Boolean> metron_f8691_0()
{    return (input) -> QUIT_COMMAND.equals(input);}
public StellarResult metron_f8692_0(String command, StellarShellExecutor executor)
{    return terminate();}
public static StellarResult metron_f8693_0(Object value)
{    return new StellarResult(Status.SUCCESS, value);}
public static StellarResult metron_f8694_0(Throwable exception)
{    return new StellarResult(Status.ERROR, exception);}
public static StellarResult metron_f8695_0(String errorMessage)
{    return new StellarResult(Status.ERROR, new IllegalArgumentException(errorMessage));}
public static StellarResult metron_f8696_0()
{    return new StellarResult(Status.SUCCESS, "");}
public static StellarResult metron_f8697_0()
{    return new StellarResult(Status.TERMINATE, "");}
public boolean metron_f8698_0()
{    return status == Status.SUCCESS;}
public boolean metron_f8699_0()
{    return status == Status.ERROR;}
public boolean metron_f8700_0()
{    return status == Status.TERMINATE;}
public boolean metron_f8701_0()
{    return isValueNull;}
public Status metron_f8702_0()
{    return status;}
public Optional<Object> metron_f8703_0()
{    return value;}
public Optional<Throwable> metron_f8704_0()
{    return exception;}
public String metron_f8705_0()
{    return "StellarResult{" + "status=" + status + ", value=" + value + ", exception=" + exception + ", isValueNull=" + isValueNull + '}';}
public static VariableResult metron_f8706_0(Object value, String expression)
{    return new VariableResult(Optional.of(expression), value);}
public static VariableResult metron_f8707_0(Object value, Optional<String> expression)
{    return new VariableResult(expression, value);}
public static VariableResult metron_f8708_0(Object value)
{    return new VariableResult(Optional.empty(), value);}
public Optional<String> metron_f8709_0()
{    return expression;}
public Object metron_f8710_0()
{    return result;}
public String metron_f8711_0()
{    String ret = "" + result;    if (getExpression().isPresent()) {        ret += " via " + expression.get();    }    return ret;}
public String metron_f8712_0()
{    return variable;}
public String metron_f8713_0()
{    return statement;}
public static boolean metron_f8714_0(String statement)
{    return statement != null &&     statement.contains(":=") &&     !statement.trim().startsWith("%");}
public static StellarAssignment metron_f8715_0(String statement)
{    if (statement == null || statement.length() == 0) {        return new StellarAssignment(null, null);    }    char prev = statement.charAt(0);    char curr;    String variable = "" + prev;    String s = null;    boolean isAssignment = false;    for (int i = 1; i < statement.length(); ++i, prev = curr) {        curr = statement.charAt(i);        if (prev == ':' && curr == '=') {            isAssignment = true;            variable = variable.substring(0, variable.length() - 1);            s = "";            continue;        }        if (!isAssignment) {            variable += curr;        } else {            s += curr;        }    }    if (!isAssignment) {        s = variable;        variable = null;    }    if (s != null) {        s = s.trim();    }    if (variable != null) {        variable = variable.trim();    }    return new StellarAssignment(variable, s);}
public String metron_f8716_0()
{    return variable;}
public Object metron_f8717_0()
{    return statement;}
public String metron_f8718_0(Object value)
{    throw new UnsupportedOperationException("Assignments are immutable.");}
public void metron_f8719_0()
{    tokenDeque.clear();    variablesUsed.clear();    multiArgumentState.clear();}
public Deque<Token<?>> metron_f8720_0()
{    return tokenDeque;}
private boolean metron_f8721_0(Class<?> tokenValueType)
{    return tokenValueType != null && (tokenValueType == BooleanArg.class || tokenValueType == IfExpr.class || tokenValueType == MatchClauseCheckExpr.class);}
private boolean metron_f8722_0(Token<?> token, Object value)
{    if (value != null && isConditionalContext(token.getUnderlyingType())) {        if (value instanceof Iterable) {            return Iterables.isEmpty((Iterable) value);        } else if (value instanceof Map) {            return ((Map) value).isEmpty();        } else {            return false;        }    } else {        return false;    }}
private boolean metron_f8723_0(Token<?> token, Object value)
{    if (token == null || token.getValue() == null) {        return false;    }    return value == null && isConditionalContext(token.getValue().getClass());}
public Object metron_f8724_0(ExpressionState state)
{    Deque<Token<?>> instanceDeque = new ArrayDeque<>();    {        int skipElseCount = 0;        boolean skipMatchClauses = false;        Token<?> token = null;        for (Iterator<Token<?>> it = getTokenDeque().descendingIterator(); it.hasNext(); ) {            token = it.next();                        if (skipElseCount > 0 && token.getUnderlyingType() == ElseExpr.class) {                while (it.hasNext()) {                    token = it.next();                    if (token.getUnderlyingType() == EndConditional.class) {                        break;                    }                }                                skipElseCount--;            }            if (skipMatchClauses && (token.getUnderlyingType() == MatchClauseEnd.class || token.getUnderlyingType() == MatchClauseCheckExpr.class)) {                while (it.hasNext()) {                    token = it.next();                    if (token.getUnderlyingType() == MatchClausesEnd.class) {                        break;                    }                }                skipMatchClauses = false;            }            /*          curr is the current value on the stack.  This is the non-deferred actual evaluation for this expression          and with the current context.           */            Token<?> curr = instanceDeque.peek();            boolean isFalsey = curr != null && (isBoolean(token, curr.getValue()) || isEmptyList(token, curr.getValue()));            if (isFalsey) {                                                                                curr = new Token<>(false, Boolean.class, curr.getMultiArgContext());                instanceDeque.removeFirst();                instanceDeque.addFirst(curr);            }            if (curr != null && curr.getValue() != null && curr.getValue() instanceof Boolean && ShortCircuitOp.class.isAssignableFrom(token.getUnderlyingType())) {                                if (token.getUnderlyingType() == BooleanArg.class) {                    if (token.getMultiArgContext() != null && token.getMultiArgContext().getVariety() == FrameContext.BOOLEAN_OR && (Boolean) (curr.getValue())) {                                                FrameContext.Context context = curr.getMultiArgContext();                        shortCircuit(it, context);                    } else if (token.getMultiArgContext() != null && token.getMultiArgContext().getVariety() == FrameContext.BOOLEAN_AND && !(Boolean) (curr.getValue())) {                                                FrameContext.Context context = curr.getMultiArgContext();                        shortCircuit(it, context);                    }                } else if (token.getUnderlyingType() == IfExpr.class) {                                        instanceDeque.pop();                    if ((Boolean) curr.getValue()) {                                                skipElseCount++;                    } else {                                                                        int innerIfCount = 0;                        while (it.hasNext()) {                            Token<?> t = it.next();                            if (t.getUnderlyingType() == IfExpr.class) {                                innerIfCount++;                            } else if (t.getUnderlyingType() == ElseExpr.class) {                                if (innerIfCount == 0) {                                    break;                                } else {                                    innerIfCount--;                                }                            }                        }                    }                } else if (token.getUnderlyingType() == MatchClauseCheckExpr.class) {                    instanceDeque.pop();                    if ((Boolean) curr.getValue()) {                                                skipMatchClauses = true;                    } else {                        while (it.hasNext()) {                            Token<?> t = it.next();                            if (t.getUnderlyingType() == MatchClauseEnd.class) {                                break;                            }                        }                    }                }            }            if (token.getUnderlyingType() == DeferredFunction.class) {                DeferredFunction func = (DeferredFunction) token.getValue();                func.apply(instanceDeque, state);            } else if (token.getUnderlyingType() != ShortCircuitFrame.class && !ShortCircuitOp.class.isAssignableFrom(token.getUnderlyingType())) {                instanceDeque.push(token);            }        }    }    if (instanceDeque.isEmpty()) {        throw new ParseException("Invalid predicate: Empty stack.");    }    Token<?> token = instanceDeque.pop();    if (instanceDeque.isEmpty()) {        return token.getValue();    }    if (instanceDeque.isEmpty()) {        throw new ParseException("Invalid parse, stack not empty: " + Joiner.on(',').join(instanceDeque));    } else {        throw new ParseException("Invalid parse, found " + token);    }}
public void metron_f8725_0(Iterator<Token<?>> it, FrameContext.Context context)
{    while (it.hasNext()) {        Token<?> token = it.next();        if (token.getUnderlyingType() == ShortCircuitFrame.class && token.getMultiArgContext() == context) {            break;        }    }}
public void metron_f8726_0(StellarParser.TransformationContext ctx)
{    expression.clear();}
private boolean metron_f8727_0(final Token<?> left, final Token<?> right)
{    Object key = right.getValue();    if (left.getValue() != null) {        if (left.getValue() instanceof String && key instanceof String) {            return ((String) left.getValue()).contains(key.toString());        } else if (left.getValue() instanceof Collection) {            return ((Collection) left.getValue()).contains(key);        } else if (left.getValue() instanceof Map) {            return ((Map) left.getValue()).containsKey(key);        } else {            if (key == null) {                return key == left.getValue();            } else {                return key.equals(left.getValue());            }        }    } else {        return false;    }}
public void metron_f8728_0(StellarParser.NullConstContext ctx)
{    expression.tokenDeque.push(new Token<>(null, Object.class, getArgContext()));}
public void metron_f8729_0(StellarParser.NaNArithContext ctx)
{    expression.tokenDeque.push(new Token<>(Double.NaN, Double.class, getArgContext()));}
public void metron_f8730_0(StellarParser.ArithExpr_plusContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Pair<Token<? extends Number>, Token<? extends Number>> p = getArithExpressionPair(tokenDeque);        tokenDeque.push(arithmeticEvaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(context), p));    }, DeferredFunction.class, context));}
public void metron_f8731_0(StellarParser.ArithExpr_minusContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Pair<Token<? extends Number>, Token<? extends Number>> p = getArithExpressionPair(tokenDeque);        tokenDeque.push(arithmeticEvaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.subtraction(context), p));    }, DeferredFunction.class, context));}
public void metron_f8732_0(StellarParser.ArithExpr_divContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Pair<Token<? extends Number>, Token<? extends Number>> p = getArithExpressionPair(tokenDeque);        tokenDeque.push(arithmeticEvaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(context), p));    }, DeferredFunction.class, context));}
public void metron_f8733_0(StellarParser.ArithExpr_mulContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Pair<Token<? extends Number>, Token<? extends Number>> p = getArithExpressionPair(tokenDeque);        tokenDeque.push(arithmeticEvaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.multiplication(context), p));    }, DeferredFunction.class, context));}
private Pair<Token<? extends Number>, Token<? extends Number>> metron_f8734_0(Deque<Token<?>> tokenDeque)
{    Token<? extends Number> right = (Token<? extends Number>) popDeque(tokenDeque);    Token<? extends Number> left = (Token<? extends Number>) popDeque(tokenDeque);    return Pair.of(left, right);}
public void metron_f8735_0(StellarParser.If_exprContext ctx)
{    expression.tokenDeque.push(new Token<>(new IfExpr(), IfExpr.class, getArgContext()));}
public void metron_f8736_0(StellarParser.Then_exprContext ctx)
{    expression.tokenDeque.push(new Token<>(new ThenExpr(), ThenExpr.class, getArgContext()));}
public void metron_f8737_0(StellarParser.Else_exprContext ctx)
{    expression.tokenDeque.push(new Token<>(new ElseExpr(), ElseExpr.class, getArgContext()));}
public void metron_f8738_0(StellarParser.Else_exprContext ctx)
{    expression.tokenDeque.push(new Token<>(new EndConditional(), EndConditional.class, getArgContext()));}
public void metron_f8739_0(StellarParser.InExpressionStatementContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Token<?> left = popDeque(tokenDeque);        Token<?> right = popDeque(tokenDeque);        tokenDeque.push(new Token<>(handleIn(left, right), Boolean.class, context));    }, DeferredFunction.class, context));}
public void metron_f8740_0(StellarParser.NInExpressionStatementContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Token<?> left = popDeque(tokenDeque);        Token<?> right = popDeque(tokenDeque);        tokenDeque.push(new Token<>(!handleIn(left, right), Boolean.class, context));    }, DeferredFunction.class, context));}
public void metron_f8741_0(StellarParser.NotFuncContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Token<Boolean> arg = (Token<Boolean>) popDeque(tokenDeque);        Boolean v = Optional.ofNullable(ConversionUtils.convert(arg.getValue(), Boolean.class)).orElse(false);        tokenDeque.push(new Token<>(!v, Boolean.class, context));    }, DeferredFunction.class, context));}
public void metron_f8742_0(StellarParser.VariableContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        String varName = ctx.getText();        if (state.context.getActivityType().equals(ActivityType.PARSE_ACTIVITY) && !state.variableResolver.exists(varName)) {                        throw new ParseException(String.format("variable: %s is not defined", varName));        }        Object resolved = state.variableResolver.resolve(varName);        tokenDeque.push(new Token<>(resolved, Object.class, context));    }, DeferredFunction.class, context));    expression.variablesUsed.add(ctx.getText());}
public void metron_f8743_0(StellarParser.StringLiteralContext ctx)
{    String rawToken = ctx.getText();    String literal = StringEscapeUtils.UNESCAPE_JSON.translate(rawToken);    expression.tokenDeque.push(new Token<>(literal.substring(1, literal.length() - 1), String.class, getArgContext()));}
public void metron_f8744_0(StellarParser.IntLiteralContext ctx)
{    expression.tokenDeque.push(numberLiteralEvaluator.evaluate(ctx, getArgContext()));}
public void metron_f8745_0(StellarParser.DoubleLiteralContext ctx)
{    expression.tokenDeque.push(numberLiteralEvaluator.evaluate(ctx, getArgContext()));}
public void metron_f8746_0(StellarParser.FloatLiteralContext ctx)
{    expression.tokenDeque.push(numberLiteralEvaluator.evaluate(ctx, getArgContext()));}
public void metron_f8747_0(StellarParser.LongLiteralContext ctx)
{    expression.tokenDeque.push(numberLiteralEvaluator.evaluate(ctx, getArgContext()));}
public void metron_f8748_0(StellarParser.B_exprContext ctx)
{        if (ctx.getParent() instanceof StellarParser.LogicalExpressionOrContext) {        expression.multiArgumentState.push(FrameContext.BOOLEAN_OR.create());    } else if (ctx.getParent() instanceof StellarParser.LogicalExpressionAndContext) {        expression.multiArgumentState.push(FrameContext.BOOLEAN_AND.create());    }}
public void metron_f8749_0(StellarParser.B_exprContext ctx)
{    if (ctx.getParent() instanceof StellarParser.LogicalExpressionOrContext || ctx.getParent() instanceof StellarParser.LogicalExpressionAndContext) {                expression.tokenDeque.push(new Token<>(new BooleanArg(), BooleanArg.class, getArgContext()));    }}
public void metron_f8750_0(StellarParser.LogicalExpressionAndContext ctx)
{    final FrameContext.Context context = getArgContext();    popArgContext();    final FrameContext.Context parentContext = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Token<?> left = popDeque(tokenDeque);        Token<?> right = popDeque(tokenDeque);        tokenDeque.push(new Token<>(booleanOp(left, right, (l, r) -> l && r, "&&"), Boolean.class, parentContext));    }, DeferredFunction.class, context));    expression.tokenDeque.push(new Token<>(new ShortCircuitFrame(), ShortCircuitFrame.class, context));}
public void metron_f8751_0(StellarParser.LogicalExpressionOrContext ctx)
{    final FrameContext.Context context = getArgContext();    popArgContext();    final FrameContext.Context parentContext = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Token<?> left = popDeque(tokenDeque);        Token<?> right = popDeque(tokenDeque);        tokenDeque.push(new Token<>(booleanOp(left, right, (l, r) -> l || r, "||"), Boolean.class, parentContext));    }, DeferredFunction.class, context));    expression.tokenDeque.push(new Token<>(new ShortCircuitFrame(), ShortCircuitFrame.class, context));}
public void metron_f8752_0(StellarParser.LogicalConstContext ctx)
{    Boolean b;    switch(ctx.getText().toUpperCase()) {        case "TRUE":            b = true;            break;        case "FALSE":            b = false;            break;        default:            throw new ParseException("Unable to process " + ctx.getText() + " as a boolean constant");    }    expression.tokenDeque.push(new Token<>(b, Boolean.class, getArgContext()));}
private boolean metron_f8753_0(final Token<?> left, final Token<?> right, final BooleanOp op, final String opName)
{    Boolean l = Optional.ofNullable(ConversionUtils.convert(left.getValue(), Boolean.class)).orElse(false);    Boolean r = Optional.ofNullable(ConversionUtils.convert(right.getValue(), Boolean.class)).orElse(false);    return op.op(l, r);}
public void metron_f8754_0(StellarParser.Single_lambda_variableContext ctx)
{    enterLambdaVariables();}
public void metron_f8755_0(StellarParser.Single_lambda_variableContext ctx)
{    exitLambdaVariables();}
public void metron_f8756_0(StellarParser.Lambda_variablesContext ctx)
{    enterLambdaVariables();}
public void metron_f8757_0(StellarParser.Lambda_variablesContext ctx)
{    exitLambdaVariables();}
public void metron_f8758_0(StellarParser.Lambda_variableContext ctx)
{    expression.tokenDeque.push(new Token<>(ctx.getText(), String.class, getArgContext()));}
private void metron_f8759_0()
{    expression.tokenDeque.push(LAMBDA_VARIABLES);}
private void metron_f8760_0()
{    Token<?> t = expression.tokenDeque.pop();    LinkedList<String> variables = new LinkedList<>();    for (; !expression.tokenDeque.isEmpty() && t != LAMBDA_VARIABLES; t = expression.tokenDeque.pop()) {        variables.addFirst(t.getValue().toString());    }    expression.tokenDeque.push(new Token<>(variables, List.class, getArgContext()));}
private void metron_f8761_0()
{    expression.tokenDeque.push(EXPRESSION_REFERENCE);}
private void metron_f8762_0(boolean hasArgs)
{    final FrameContext.Context context = getArgContext();    Token<?> t = expression.tokenDeque.pop();    final Deque<Token<?>> instanceDeque = new ArrayDeque<>();    for (; !expression.tokenDeque.isEmpty() && t != EXPRESSION_REFERENCE; t = expression.tokenDeque.pop()) {        instanceDeque.addLast(t);    }    final List<String> variables = hasArgs ? (List<String>) instanceDeque.removeLast().getValue() : new ArrayList<>();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        LambdaExpression expr = new LambdaExpression(variables, instanceDeque, state);        tokenDeque.push(new Token<>(expr, Object.class, context));    }, DeferredFunction.class, context));}
public void metron_f8763_0(StellarParser.Lambda_with_argsContext ctx)
{    enterLambda();}
public void metron_f8764_0(StellarParser.Lambda_with_argsContext ctx)
{    exitLambda(true);}
public void metron_f8765_0(StellarParser.Lambda_without_argsContext ctx)
{    enterLambda();}
public void metron_f8766_0(StellarParser.Lambda_without_argsContext ctx)
{    exitLambda(false);}
public void metron_f8767_0(StellarParser.TransformationFuncContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {                String functionName = ctx.getChild(0).getText();        StellarFunction function = resolveFunction(state.functionResolver, functionName);        initializeFunction(state.context, function, functionName);                List<Object> args = getFunctionArguments(popDeque(tokenDeque));        Object result = function.apply(args, state.context);        tokenDeque.push(new Token<>(result, Object.class, context));    }, DeferredFunction.class, context));}
private List<Object> metron_f8768_0(final Token<?> token)
{    if (token.getUnderlyingType().equals(List.class)) {        return (List<Object>) token.getValue();    } else {        throw new ParseException("Unable to process in clause because " + token.getValue() + " is not a set");    }}
private StellarFunction metron_f8769_0(FunctionResolver functionResolver, String funcName)
{    try {        return functionResolver.apply(funcName);    } catch (Exception e) {        String valid = Joiner.on(',').join(functionResolver.getFunctions());        String error = format("Unable to resolve function named '%s'.  Valid functions are %s", funcName, valid);        throw new ParseException(error, e);    }}
private void metron_f8770_0(Context context, StellarFunction function, String functionName)
{    try {        if (!function.isInitialized()) {            function.initialize(context);        }    } catch (Throwable t) {        String error = format("Unable to initialize function '%s'", functionName);        throw new ParseException(error, t);    }}
public void metron_f8771_0(StellarParser.ExistsFuncContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        String variable = ctx.getChild(2).getText();        boolean exists = state.variableResolver.resolve(variable) != null;        tokenDeque.push(new Token<>(exists, Boolean.class, context));    }, DeferredFunction.class, context));    String variable = ctx.getChild(2).getText();    expression.variablesUsed.add(variable);}
public void metron_f8772_0(StellarParser.Func_argsContext ctx)
{    expression.tokenDeque.push(new Token<>(new FunctionMarker(), FunctionMarker.class, getArgContext()));}
public void metron_f8773_0(StellarParser.Func_argsContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        LinkedList<Object> args = new LinkedList<>();        while (true) {            Token<?> token = popDeque(tokenDeque);            if (token.getUnderlyingType().equals(FunctionMarker.class)) {                break;            } else {                args.addFirst(token.getValue());            }        }        tokenDeque.push(new Token<>(args, List.class, context));    }, DeferredFunction.class, context));}
public void metron_f8774_0(StellarParser.Map_entityContext ctx)
{    expression.tokenDeque.push(new Token<>(new FunctionMarker(), FunctionMarker.class, getArgContext()));}
public void metron_f8775_0(StellarParser.Map_entityContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        HashMap<Object, Object> args = new HashMap<>();        Object value = null;        for (int i = 0; true; i++) {            Token<?> token = popDeque(tokenDeque);            if (token.getUnderlyingType().equals(FunctionMarker.class)) {                break;            } else {                if (i % 2 == 0) {                    value = token.getValue();                } else {                    args.put(token.getValue(), value);                }            }        }        tokenDeque.push(new Token<>(args, Map.class, context));    }, DeferredFunction.class, context));}
public void metron_f8776_0(StellarParser.List_entityContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        LinkedList<Object> args = new LinkedList<>();        while (true) {            Token<?> token = popDeque(tokenDeque);            if (token.getUnderlyingType().equals(FunctionMarker.class)) {                break;            } else {                args.addFirst(token.getValue());            }        }        tokenDeque.push(new Token<>(args, List.class, context));    }, DeferredFunction.class, context));}
public void metron_f8777_0(StellarParser.DefaultContext ctx)
{    expression.tokenDeque.push(new Token<>(true, Boolean.class, getArgContext()));}
public void metron_f8778_0(StellarParser.MatchClauseCheckExprContext ctx)
{    final FrameContext.Context context = getArgContext();        if (ctx.getStart() == ctx.getStop()) {        expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {            if (tokenDeque.size() == 1 && (tokenDeque.peek().getValue() == null || tokenDeque.peek().getUnderlyingType() == Boolean.class)) {                tokenDeque.pop();                tokenDeque.add(new Token<>(false, Boolean.class, getArgContext()));            }        }, DeferredFunction.class, context));    }    expression.tokenDeque.push(new Token<>(new MatchClauseCheckExpr(), MatchClauseCheckExpr.class, getArgContext()));}
public void metron_f8779_0(StellarParser.MatchClauseActionContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        Token<?> token = popDeque(tokenDeque);        Object value = token.getValue();        if (value != null && LambdaExpression.class.isAssignableFrom(value.getClass())) {            LambdaExpression expr = (LambdaExpression) value;                                                                        Object result = expr.apply(new ArrayList<>());            tokenDeque.push(new Token<>(result, Object.class, context));        } else {            tokenDeque.push(new Token<>(value, Object.class, context));        }    }, DeferredFunction.class, context));}
public void metron_f8780_0(StellarParser.Match_clauseContext ctx)
{    expression.tokenDeque.push(new Token<>(new MatchClauseEnd(), MatchClauseEnd.class, getArgContext()));}
public void metron_f8781_0(StellarParser.MatchClausesContext ctx)
{    expression.tokenDeque.push(new Token<>(new MatchClausesEnd(), MatchClausesEnd.class, getArgContext()));}
public void metron_f8782_0(StellarParser.ComparisonExpressionWithOperatorContext ctx)
{    final FrameContext.Context context = getArgContext();    expression.tokenDeque.push(new Token<>((tokenDeque, state) -> {        StellarParser.Comp_operatorContext op = ctx.comp_operator();        Token<?> right = popDeque(tokenDeque);        Token<?> left = popDeque(tokenDeque);        tokenDeque.push(comparisonExpressionWithOperatorEvaluator.evaluate(left, right, (StellarParser.ComparisonOpContext) op, context));    }, DeferredFunction.class, context));}
public void metron_f8783_0(StellarParser.List_entityContext ctx)
{    expression.tokenDeque.push(new Token<>(new FunctionMarker(), FunctionMarker.class, getArgContext()));}
private void metron_f8784_0()
{    if (!expression.multiArgumentState.isEmpty()) {        expression.multiArgumentState.pop();    }}
private FrameContext.Context metron_f8785_0()
{    return expression.multiArgumentState.isEmpty() ? null : expression.multiArgumentState.peek();}
private Token<?> metron_f8786_0(Deque<Token<?>> tokenDeque)
{    if (tokenDeque.isEmpty()) {        throw new ParseException("Unable to pop an empty stack");    }    return tokenDeque.pop();}
public Expression metron_f8787_0()
{    return expression;}
public Boolean metron_f8788_0(String rule, VariableResolver variableResolver, FunctionResolver functionResolver, Context context)
{    if (rule == null || isEmpty(rule.trim())) {        return true;    }    try {        return super.parse(rule, variableResolver, functionResolver, context);    } catch (ClassCastException e) {                throw new IllegalArgumentException(String.format("The rule '%s' does not return a boolean value.", rule), e);    } catch (Exception e) {        if (e.getCause() != null && e.getCause() instanceof ClassCastException) {            throw new IllegalArgumentException(String.format("The rule '%s' does not return a boolean value.", rule), e.getCause());        }        throw e;    }}
public long metron_f8789_0()
{    return System.currentTimeMillis();}
public String metron_f8790_0(String stdDateFormat)
{    SimpleDateFormat format = new SimpleDateFormat(stdDateFormat);    format.setTimeZone(TimeZone.getTimeZone(UTC));    return format.format(new Date(currentTimeMillis()));}
public String metron_f8791_0(String variable)
{    return System.getenv().get(variable);}
public void metron_f8792_0(T obj, PrimitiveSink primitiveSink)
{    primitiveSink.putBytes(serializer.apply(obj));}
public boolean metron_f8793_0(Object obj)
{    return this.getClass().equals(obj.getClass());}
public int metron_f8794_0()
{    return super.hashCode() * 31;}
public byte[] metron_f8795_0(T t)
{    return SerDeUtils.toBytes(t);}
public boolean metron_f8796_0(T key)
{    return filter.mightContain(key);}
public void metron_f8797_0(T key)
{    filter.put(key);}
public void metron_f8798_0(BloomFilter<T> filter2)
{    filter.putAll(filter2.filter);}
public boolean metron_f8799_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    BloomFilter<?> that = (BloomFilter<?>) o;    return filter != null ? filter.equals(that.filter) : that.filter == null;}
public int metron_f8800_0()
{    return filter != null ? filter.hashCode() : 0;}
public Optional<Object> metron_f8801_0(OPT_T option, CommandLine cli)
{    return Optional.empty();}
public int metron_f8802_0()
{    int size = 0;    for (Map m : variableMappings) {        size += m.size();    }    return size;}
public boolean metron_f8803_0()
{    boolean isEmpty = true;    for (Map m : variableMappings) {        isEmpty &= m.isEmpty();    }    return isEmpty;}
public boolean metron_f8804_0(Object key)
{    for (Map m : variableMappings) {        if (m.containsKey(key)) {            return true;        }    }    return false;}
public boolean metron_f8805_0(Object value)
{    for (Map m : variableMappings) {        if (m.containsValue(value)) {            return true;        }    }    return false;}
public Object metron_f8806_0(Object key)
{    Object ret = null;    for (Map m : variableMappings) {        ret = m.get(key);        if (ret != null) {            break;        }    }    return ret;}
public Object metron_f8807_0(String key, Object value)
{    throw new UnsupportedOperationException("Merged map is immutable.");}
public Object metron_f8808_0(Object key)
{    throw new UnsupportedOperationException("Merged map is immutable.");}
public void metron_f8809_0(Map<? extends String, ?> m)
{    throw new UnsupportedOperationException("Merged map is immutable.");}
public void metron_f8810_0()
{    throw new UnsupportedOperationException("Merged map is immutable.");}
public Set<String> metron_f8811_0()
{    Set<String> ret = null;    for (Map m : variableMappings) {        if (ret == null) {            ret = m.keySet();        } else {            ret = Sets.union(ret, m.keySet());        }    }    return ret;}
public Collection<Object> metron_f8812_0()
{    Collection<Object> ret = new ArrayList<>(size());    for (Map m : variableMappings) {        ret.addAll(m.values());    }    return ret;}
public Set<Entry<String, Object>> metron_f8813_0()
{    Set<Entry<String, Object>> ret = null;    for (Map m : variableMappings) {        if (ret == null) {            ret = m.entrySet();        } else {            ret = Sets.union(ret, m.entrySet());        }    }    return ret;}
public String metron_f8814_0()
{    Iterable<Iterable<Map.Entry<Object, Object>>> transformed = Iterables.transform(variableMappings, x -> x.entrySet());    Iterable<Map.Entry<Object, Object>> it = Iterables.filter(Iterables.concat(transformed), x -> x.getValue() != null);    return "{" + Joiner.on(", ").join(it) + "}";}
public boolean metron_f8815_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ConcatMap concatMap = (ConcatMap) o;    return variableMappings != null ? variableMappings.equals(concatMap.variableMappings) : concatMap.variableMappings == null;}
public int metron_f8816_0()
{    return variableMappings != null ? variableMappings.hashCode() : 0;}
public void metron_f8817_0(Kryo kryo, Output output)
{    int numVariableMappings = variableMappings.isEmpty() ? 0 : variableMappings.size();    output.writeShort(numVariableMappings);    for (Map m : variableMappings) {        byte[] b = m == null ? new byte[] {} : SerDeUtils.toBytes(m);        output.writeInt(b.length);        if (b.length > 0) {            output.writeBytes(b);        }    }}
public void metron_f8818_0(Kryo kryo, Input input)
{    int numVariableMappings = input.readShort();    variableMappings = new ArrayList<>(numVariableMappings);    for (int i = 0; i < numVariableMappings; ++i) {        int size = input.readInt();        if (size > 0) {            byte[] bytes = input.readBytes(size);            Map m = SerDeUtils.fromBytes(bytes, Map.class);            variableMappings.add(m);        }    }}
protected ConvertUtilsBean metron_f8819_0()
{    ConvertUtilsBean ret = BeanUtilsBean2.getInstance().getConvertUtils();    ret.deregister();    ret.register(false, true, 1);    return ret;}
public static T metron_f8820_0(Object o, Class<T> clazz)
{    if (o == null) {        return null;    }    return clazz.cast(UTILS_BEAN.get().convert(o, clazz));}
public static List<U> metron_f8821_0(List<T> from, Class<U> clazz)
{    return Lists.transform(from, s -> convert(s, clazz));}
public static Map<K, V2> metron_f8822_0(Map<K, V1> from, Class<V2> clazz)
{    return Maps.transformValues(from, s -> convert(s, clazz));}
public String metron_f8823_0()
{    return key;}
public String metron_f8824_0(final Object toHash) throws EncoderException, NoSuchAlgorithmException
{    final MessageDigest messageDigest = MessageDigest.getInstance(algorithm);    if (toHash == null) {        return StringUtils.repeat("00", messageDigest.getDigestLength());    } else if (toHash instanceof String) {        return getHash(messageDigest, toHash.toString().getBytes(charset));    } else if (toHash instanceof Serializable) {        final byte[] serialized = SerializationUtils.serialize((Serializable) toHash);        return getHash(messageDigest, serialized);    }    return null;}
private String metron_f8825_0(final MessageDigest messageDigest, final byte[] toHash) throws EncoderException
{    messageDigest.update(toHash);    final byte[] encode = encoder.encode(messageDigest.digest());    return new String(encode, charset);}
public void metron_f8826_0(Optional<Map<String, Object>> config)
{    if (config.isPresent() && !config.get().isEmpty()) {        charset = Config.CHARSET.get(config.get(), o -> {            String charset = ConversionUtils.convert(o, String.class);            if (charset != null) {                Charset set = Charset.forName(charset);                return set;            }            return null;        }).orElse(charset);    }}
public static final Set<String> metron_f8827_0()
{    return new HashSet<>(Security.getAlgorithms("MessageDigest"));}
 Optional<T> metron_f8828_0(Map<String, Object> config, Function<Object, T> converter)
{    Object o = config.get(getKey());    return o == null ? Optional.empty() : Optional.ofNullable(converter.apply(o));}
public static Hasher metron_f8829_0(String algorithm, Optional<Map<String, Object>> config)
{    Hasher h = null;    for (HashStrategy factory : HashStrategy.values()) {        if (factory.getSupportedHashes().contains(algorithm.toUpperCase())) {            h = factory.hasherCreator.apply(algorithm);            break;        }    }    if (h == null) {        throw new IllegalArgumentException("Unsupported hash function: " + algorithm + ".  Supported algorithms are " + Joiner.on(",").join(ALL_SUPPORTED_HASHES));    }    h.configure(config);    return h;}
public Set<String> metron_f8830_0()
{    return supportedHashes;}
public String metron_f8831_0(byte[] data, boolean force)
{    try {        creator.update(data);        return creator.getHash(force).getEncoded();    } finally {        creator.reset();    }}
public static int metron_f8832_0(String hash1, String hash2, Optional<Boolean> includeLength)
{    if (hash1 == null || hash2 == null) {        return -1;    }    if (hash1.equals(hash2)) {        return 0;    }    Tlsh t1 = Tlsh.fromTlshStr(hash1);    Tlsh t2 = Tlsh.fromTlshStr(hash2);    return t1.totalDiff(t2, includeLength.orElse(false));}
public TLSH metron_f8833_0(BucketOption bo, ChecksumOption co)
{    return cache.computeIfAbsent(new AbstractMap.SimpleEntry<>(bo, co), kv -> new TLSH(kv.getKey(), kv.getValue()));}
public String metron_f8834_0()
{    return key;}
public Object metron_f8835_0(Object o) throws EncoderException, NoSuchAlgorithmException
{    TLSH tlsh = TLSHCache.INSTANCE.get().getTLSH(bucketOption, checksumOption);    byte[] data = null;    if (o instanceof String) {        data = ((String) o).getBytes(StandardCharsets.UTF_8);    } else if (o instanceof byte[]) {        data = (byte[]) o;    } else {        data = SerDeUtils.toBytes(o);    }    try {        String hash = tlsh.apply(data, force);        if (hashes != null && hashes.size() > 0) {            Map<String, Object> ret = new HashMap<>();            ret.put(TLSH_KEY, hash);            ret.putAll(bin(hash));            return ret;        } else {            return hash;        }    } catch (Exception e) {        return null;    }}
public Map<String, String> metron_f8836_0(String hash) throws DecoderException
{    Random r = new Random(0);    byte[] h = Hex.decodeHex(hash.substring(2 * checksumOption.getChecksumLength()).toCharArray());    BitSet vector = BitSet.valueOf(h);    int n = vector.length();    Map<String, String> ret = new HashMap<>();    boolean singleHash = hashes.size() == 1;    for (int numHashes : hashes) {        BitSet projection = new BitSet();        for (int i = 0; i < numHashes; ++i) {            int index = r.nextInt(n);            projection.set(i, vector.get(index));        }        String outputHash = numHashes + Hex.encodeHexString(projection.toByteArray());        if (singleHash) {            ret.put(TLSH_BIN_KEY, outputHash);        } else {            ret.put(TLSH_BIN_KEY + "_" + numHashes, outputHash);        }    }    return ret;}
public void metron_f8837_0(Optional<Map<String, Object>> config)
{    if (config.isPresent() && !config.get().isEmpty()) {        bucketOption = Config.BUCKET_SIZE.get(config.get(), o -> {            Integer bucketSize = ConversionUtils.convert(o, Integer.class);            switch(bucketSize) {                case 128:                    return BucketOption.BUCKETS_128;                case 256:                    return BucketOption.BUCKETS_256;                default:                    return null;            }        }).orElse(bucketOption);        checksumOption = Config.CHECKSUM.get(config.get(), o -> {            Integer checksumBytes = ConversionUtils.convert(o, Integer.class);            switch(checksumBytes) {                case 1:                    return ChecksumOption.CHECKSUM_1B;                case 3:                    return ChecksumOption.CHECKSUM_3B;                default:                    return null;            }        }).orElse(checksumOption);        force = Config.FORCE.get(config.get(), o -> ConversionUtils.convert(o, Boolean.class)).orElse(force);        hashes = Config.HASHES.get(config.get(), o -> {            List<Integer> ret = new ArrayList<>();            if (o instanceof List) {                List<? extends Object> vals = (List<? extends Object>) o;                for (Object oVal : vals) {                    ret.add(ConversionUtils.convert(oVal, Integer.class));                }            } else {                ret.add(ConversionUtils.convert(o, Integer.class));            }            return ret;        }).orElse(hashes);    }}
public static final Set<String> metron_f8838_0()
{    return new HashSet<String>() {        {            add("TLSH");        }    };}
public TypeReference<T> metron_f8839_0()
{    return new TypeReference<T>() {        @Override        public Type getType() {            return type;        }    };}
public Type metron_f8840_0()
{    return type;}
public T metron_f8841_0(InputStream is, ReferenceSupplier<T> ref) throws IOException
{    return _mapper.get().readValue(is, (TypeReference<T>) ref.get());}
public T metron_f8842_0(String is, ReferenceSupplier<T> ref) throws IOException
{    return _mapper.get().readValue(is, (TypeReference<T>) ref.get());}
public T metron_f8843_0(File f, ReferenceSupplier<T> ref) throws IOException
{    try (InputStream is = new BufferedInputStream(new FileInputStream(f))) {        return _mapper.get().readValue(is, (TypeReference<T>) ref.get());    }}
public T metron_f8844_0(InputStream is, Class<T> clazz) throws IOException
{    return _mapper.get().readValue(is, clazz);}
public T metron_f8845_0(File f, Class<T> clazz) throws IOException
{    try (InputStream is = new BufferedInputStream(new FileInputStream(f))) {        return _mapper.get().readValue(is, clazz);    }}
public T metron_f8846_0(String is, Class<T> clazz) throws IOException
{    return _mapper.get().readValue(is, clazz);}
public String metron_f8847_0(Object o, boolean pretty) throws JsonProcessingException
{    if (pretty) {        return _mapper.get().writerWithDefaultPrettyPrinter().writeValueAsString(o);    } else {        return _mapper.get().writeValueAsString(o);    }}
public byte[] metron_f8848_0(Object config) throws JsonProcessingException
{    return _mapper.get().writeValueAsBytes(config);}
public JSONObject metron_f8849_0(Object o) throws JsonProcessingException, ParseException
{    return toJSONObject(toJSON(o, false));}
public JSONObject metron_f8850_0(String json) throws ParseException
{    return (JSONObject) _parser.get().parse(json);}
public int metron_f8851_0()
{    return maxArgs;}
public int metron_f8852_0()
{    return minArgs;}
public Function<Number[], Number> metron_f8853_0()
{    return operation;}
public Number metron_f8854_0(Number[] numbers)
{    return f.apply(numbers[0].doubleValue());}
public Number metron_f8855_0(Number[] numbers)
{    return f.apply(numbers[0].doubleValue(), numbers[1].doubleValue());}
public Number metron_f8856_0(Number[] in)
{    return op.getOperation().apply(in);}
public Object metron_f8857_0(List<Object> args, Context context) throws ParseException
{    if (args.size() < _func.getMinArgs()) {        return Double.NaN;    }    Number[] nums = new Number[_func.getMaxArgs()];    for (int i = 0; i < _func.getMaxArgs(); ++i) {        nums[i] = (Number) args.get(i);        if (nums[i] == null) {            return Double.NaN;        }    }    Object ret = _func.getOperation().apply(nums);    return ret;}
public boolean metron_f8859_0()
{    return true;}
public Pattern metron_f8860_0(String patternString)
{    Pattern pattern = _cache.get().get(patternString);    if (pattern == null) {        pattern = Pattern.compile(patternString);        _cache.get().put(patternString, pattern);    }    return pattern;}
protected Kryo metron_f8861_0()
{    Kryo ret = new Kryo();    ret.setReferences(true);    ret.setInstantiatorStrategy(new DefaultInstantiatorStrategy(new StdInstantiatorStrategy()));    ret.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());    ret.register(Collections.EMPTY_LIST.getClass(), new CollectionsEmptyListSerializer());    ret.register(Collections.EMPTY_MAP.getClass(), new CollectionsEmptyMapSerializer());    ret.register(Collections.EMPTY_SET.getClass(), new CollectionsEmptySetSerializer());    ret.register(Collections.singletonList("").getClass(), new CollectionsSingletonListSerializer());    ret.register(Collections.singleton("").getClass(), new CollectionsSingletonSetSerializer());    ret.register(Collections.singletonMap("", "").getClass(), new CollectionsSingletonMapSerializer());    ret.register(GregorianCalendar.class, new GregorianCalendarSerializer());    ret.register(InvocationHandler.class, new JdkProxySerializer());    UnmodifiableCollectionsSerializer.registerSerializers(ret);    SynchronizedCollectionsSerializer.registerSerializers(ret);            ret.register(CGLibProxySerializer.CGLibProxyMarker.class, new CGLibProxySerializer());        ret.register(LocalDate.class, new JodaLocalDateSerializer());    ret.register(LocalDateTime.class, new JodaLocalDateTimeSerializer());        ImmutableListSerializer.registerSerializers(ret);    ImmutableSetSerializer.registerSerializers(ret);    ImmutableMapSerializer.registerSerializers(ret);    ImmutableMultimapSerializer.registerSerializers(ret);    return ret;}
public void metron_f8862_0(final InstantiatorStrategy fallbackStrategy)
{    this.fallbackStrategy = fallbackStrategy;}
public InstantiatorStrategy metron_f8863_0()
{    return fallbackStrategy;}
public ObjectInstantiator metron_f8864_0(final Class type)
{    if (!Util.isAndroid) {                Class enclosingType = type.getEnclosingClass();        boolean isNonStaticMemberClass = enclosingType != null && type.isMemberClass() && !Modifier.isStatic(type.getModifiers());        if (!isNonStaticMemberClass) {            try {                final ConstructorAccess access = ConstructorAccess.get(type);                return new ObjectInstantiator() {                    @Override                    public Object newInstance() {                        try {                            return access.newInstance();                        } catch (Exception ex) {                            throw new KryoException("Error constructing instance of class: " + className(type), ex);                        }                    }                };            } catch (Exception ignored) {            }        }    }        try {        Constructor ctor;        try {            ctor = type.getConstructor((Class[]) null);        } catch (Exception ex) {            ctor = type.getDeclaredConstructor((Class[]) null);            ctor.setAccessible(true);        }        final Constructor constructor = ctor;        return new ObjectInstantiator() {            @Override            public Object newInstance() {                try {                    return constructor.newInstance();                } catch (Exception ex) {                    throw new KryoException("Error constructing instance of class: " + className(type), ex);                }            }        };    } catch (Exception ignored) {    }    if (fallbackStrategy == null) {        if (type.isMemberClass() && !Modifier.isStatic(type.getModifiers()))            throw new KryoException("Class cannot be created (non-static member class): " + className(type));        else            throw new KryoException("Class cannot be created (missing no-arg constructor): " + className(type));    }        return fallbackStrategy.newInstantiatorOf(type);}
public Object metron_f8865_0()
{    try {        return access.newInstance();    } catch (Exception ex) {        throw new KryoException("Error constructing instance of class: " + className(type), ex);    }}
public Object metron_f8866_0()
{    try {        return constructor.newInstance();    } catch (Exception ex) {        throw new KryoException("Error constructing instance of class: " + className(type), ex);    }}
public byte[] metron_f8867_0(Object o)
{    return toBytes(o);}
public T metron_f8868_0(byte[] bytes)
{    return fromBytes(bytes, clazz);}
public static byte[] metron_f8869_1(Object value)
{    try {        ByteArrayOutputStream bos = new ByteArrayOutputStream();        Output output = new Output(bos);        kryo.get().writeClassAndObject(output, value);        output.flush();        bos.flush();        return bos.toByteArray();    } catch (Throwable t) {                throw new IllegalStateException("Unable to serialize " + value + " because " + t.getMessage(), t);    }}
public static T metron_f8870_1(byte[] value, Class<T> clazz)
{    try {        Input input = new Input(new ByteArrayInputStream(value));        return clazz.cast(kryo.get().readClassAndObject(input));    } catch (Throwable t) {                throw t;    }}
public static Object metron_f8871_0(String expression, VariableResolver varResolver, Context context)
{    validate(expression, context);    Object result = execute(expression, varResolver, context);    ensureKryoSerializable(result, expression);    ensureJavaSerializable(result, expression);    return result;}
public static Object metron_f8872_0(String expression, Map<String, Object> variables, Context context)
{    VariableResolver varResolver = new DefaultVariableResolver(x -> {        if (x.equals(MapVariableResolver.ALL_FIELDS)) {            return variables;        }        return variables.get(x);    }, x -> x.equals(MapVariableResolver.ALL_FIELDS) || variables.containsKey(x));    return run(expression, varResolver, context);}
private static Object metron_f8873_0(String expression, VariableResolver variableResolver, Context context)
{    StellarProcessor processor = new StellarProcessor();    Object result = processor.parse(expression, variableResolver, StellarFunctions.FUNCTION_RESOLVER(), context);    return result;}
private static void metron_f8874_0(Object value, String expression)
{    String msg = String.format("Expression result is not Kryo serializable. It is highly recommended for all " + "functions to return a result that is Kryo serializable to allow for their broadest possible use. " + "expr=%s, value=%s", expression, value);    byte[] raw = SerDeUtils.toBytes(value);    Object actual = SerDeUtils.fromBytes(raw, Object.class);    Assert.assertEquals(msg, value, actual);}
private static void metron_f8875_0(Object value, String expression)
{    String msg = String.format("Expression result is not Java serializable. It is highly recommended for all " + "functions to return a result that is Java serializable to allow for their broadest possible use. " + "expr=%s, value=%s", expression, value);    try {                ByteArrayOutputStream bytes = new ByteArrayOutputStream();        ObjectOutputStream out = new ObjectOutputStream(bytes);        out.writeObject(value);                byte[] raw = bytes.toByteArray();        assertTrue(raw.length > 0);                ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(raw));        Object actual = in.readObject();                assertEquals(msg, value, actual);    } catch (IOException | ClassNotFoundException e) {        String error = String.format("Expression result is not Java serializable. It is highly recommended for all " + "functions to return a result that is Java serializable to allow for their broadest possible use. " + "expr=%s, value=%s, error=%s", expression, value, ExceptionUtils.getRootCauseMessage(e));        fail(error);    }}
public static Object metron_f8876_0(String expression, Map<String, Object> variables)
{    return run(expression, variables, Context.EMPTY_CONTEXT());}
public static Object metron_f8877_0(String expression, VariableResolver variables)
{    return run(expression, variables, Context.EMPTY_CONTEXT());}
public static Object metron_f8878_0(String expression, Context context)
{    return run(expression, Collections.emptyMap(), context);}
public static void metron_f8879_0(String expression, Context context)
{    StellarProcessor processor = new StellarProcessor();    Assert.assertTrue("Invalid expression; expr=" + expression, processor.validate(expression, context));}
public static void metron_f8880_0(String rule)
{    validate(rule, Context.EMPTY_CONTEXT());}
public static boolean metron_f8881_0(String rule, Map resolver)
{    return runPredicate(rule, resolver, Context.EMPTY_CONTEXT());}
public static boolean metron_f8882_0(String rule, Map resolver, Context context)
{    return runPredicate(rule, new MapVariableResolver(resolver), context);}
public static boolean metron_f8883_0(String rule, VariableResolver resolver)
{    return runPredicate(rule, resolver, Context.EMPTY_CONTEXT());}
public static boolean metron_f8884_0(String rule, VariableResolver resolver, Context context)
{    StellarPredicateProcessor processor = new StellarPredicateProcessor();    Assert.assertTrue(rule + " not valid.", processor.validate(rule));    return processor.parse(rule, resolver, StellarFunctions.FUNCTION_RESOLVER(), context);}
public static void metron_f8885_0(String function, Object argument, Object expected)
{    runWithArguments(function, ImmutableList.of(argument), expected);}
public static void metron_f8886_0(String function, List<Object> arguments, Object expected)
{    Supplier<Stream<Map.Entry<String, Object>>> kvStream = () -> StreamSupport.stream(new XRange(arguments.size()), false).map(i -> new AbstractMap.SimpleImmutableEntry<>("var" + i, arguments.get(i)));    String args = kvStream.get().map(kv -> kv.getKey()).collect(Collectors.joining(","));    Map<String, Object> variables = kvStream.get().collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()));    String stellarStatement = function + "(" + args + ")";    String reason = stellarStatement + " != " + expected + " with variables: " + variables;    if (expected instanceof Double) {        Assert.assertEquals(reason, (Double) expected, (Double) run(stellarStatement, variables), 1e-6);    } else {        Assert.assertEquals(reason, expected, run(stellarStatement, variables));    }}
public boolean metron_f8887_0(IntConsumer action)
{    boolean isDone = i >= end;    if (isDone) {        return false;    } else {        action.accept(i);        i++;        return true;    }}
public boolean metron_f8888_0(Consumer<? super Integer> action)
{    boolean isDone = i >= end;    if (isDone) {        return false;    } else {        action.accept(i);        i++;        return true;    }}
public static FileSystemManager metron_f8889_0() throws FileSystemException
{    DefaultFileSystemManager vfs = new DefaultFileSystemManager();    vfs.addProvider("res", new org.apache.commons.vfs2.provider.res.ResourceFileProvider());    vfs.addProvider("zip", new org.apache.commons.vfs2.provider.zip.ZipFileProvider());    vfs.addProvider("gz", new org.apache.commons.vfs2.provider.gzip.GzipFileProvider());    vfs.addProvider("ram", new org.apache.commons.vfs2.provider.ram.RamFileProvider());    vfs.addProvider("file", new org.apache.commons.vfs2.provider.local.DefaultLocalFileProvider());    vfs.addProvider("jar", new org.apache.commons.vfs2.provider.jar.JarFileProvider());    vfs.addProvider("http", new org.apache.commons.vfs2.provider.http.HttpFileProvider());    vfs.addProvider("https", new org.apache.commons.vfs2.provider.https.HttpsFileProvider());    vfs.addProvider("ftp", new org.apache.commons.vfs2.provider.ftp.FtpFileProvider());    vfs.addProvider("ftps", new org.apache.commons.vfs2.provider.ftps.FtpsFileProvider());    vfs.addProvider("war", new org.apache.commons.vfs2.provider.jar.JarFileProvider());    vfs.addProvider("par", new org.apache.commons.vfs2.provider.jar.JarFileProvider());    vfs.addProvider("ear", new org.apache.commons.vfs2.provider.jar.JarFileProvider());    vfs.addProvider("sar", new org.apache.commons.vfs2.provider.jar.JarFileProvider());    vfs.addProvider("ejb3", new org.apache.commons.vfs2.provider.jar.JarFileProvider());    vfs.addProvider("tmp", new org.apache.commons.vfs2.provider.temp.TemporaryFileProvider());    vfs.addProvider("tar", new org.apache.commons.vfs2.provider.tar.TarFileProvider());    vfs.addProvider("tbz2", new org.apache.commons.vfs2.provider.tar.TarFileProvider());    vfs.addProvider("tgz", new org.apache.commons.vfs2.provider.tar.TarFileProvider());    vfs.addProvider("bz2", new org.apache.commons.vfs2.provider.bzip2.Bzip2FileProvider());    vfs.addProvider("hdfs", new HdfsFileProvider());    vfs.addExtensionMap("jar", "jar");    vfs.addExtensionMap("zip", "zip");    vfs.addExtensionMap("gz", "gz");    vfs.addExtensionMap("tar", "tar");    vfs.addExtensionMap("tbz2", "tar");    vfs.addExtensionMap("tgz", "tar");    vfs.addExtensionMap("bz2", "bz2");    vfs.addMimeTypeMap("application/x-tar", "tar");    vfs.addMimeTypeMap("application/x-gzip", "gz");    vfs.addMimeTypeMap("application/zip", "zip");    vfs.setFileContentInfoFactory(new FileContentInfoFilenameFactory());    vfs.setFilesCache(new SoftRefFilesCache());    vfs.setReplicator(new UniqueFileReplicator(new File(System.getProperty("java.io.tmpdir"))));    vfs.setCacheStrategy(CacheStrategy.ON_RESOLVE);    vfs.init();    return vfs;}
public static Optional<ClassLoader> metron_f8890_1(String paths) throws FileSystemException
{        if (paths.trim().isEmpty()) {                return Optional.empty();    }    FileSystemManager vfs = generateVfs();    FileObject[] objects = resolve(vfs, paths);    if (objects == null || objects.length == 0) {                return Optional.empty();    }        return Optional.of(new VFSClassLoader(objects, vfs, vfs.getClass().getClassLoader()));}
 static FileObject[] metron_f8891_1(FileSystemManager vfs, String uris) throws FileSystemException
{    if (uris == null) {        return new FileObject[0];    }    ArrayList<FileObject> classpath = new ArrayList<>();    for (String path : uris.split(",")) {        path = path.trim();        if (path.equals("")) {            continue;        }        FileObject fo = vfs.resolveFile(path);        switch(fo.getType()) {            case FILE:            case FOLDER:                classpath.add(fo);                break;            case IMAGINARY:                                String pattern = fo.getName().getBaseName();                if (fo.getParent() != null && fo.getParent().getType() == FileType.FOLDER) {                    FileObject[] children = fo.getParent().getChildren();                    for (FileObject child : children) {                        if (child.getType() == FileType.FILE && child.getName().getBaseName().matches(pattern)) {                            classpath.add(child);                        }                    }                } else {                                    }                break;            default:                                break;        }    }    return classpath.toArray(new FileObject[classpath.size()]);}
public Object metron_f8892_0(List<Object> args, Context context) throws ParseException
{    return apply(args);}
public boolean metron_f8894_0()
{    return true;}
public Builder metron_f8895_0(String s, Capability capability)
{    capabilityMap.put(s, capability);    return this;}
public Builder metron_f8896_0(Enum<?> s, Capability capability)
{    capabilityMap.put(s.toString(), capability);    return this;}
public Builder metron_f8897_0(Map<String, Object> externalConfig)
{    for (Map.Entry<String, Object> entry : externalConfig.entrySet()) {        capabilityMap.put(entry.getKey(), () -> entry.getValue());    }    return this;}
public Context metron_f8898_0()
{    return new Context(capabilityMap);}
public static Context metron_f8899_0()
{    return new Context(new HashMap<>()) {    };}
public Optional<Object> metron_f8900_0(Enum<?> capability)
{    return getCapability(capability, true);}
public Optional<Object> metron_f8901_0(Enum<?> capability, boolean errorIfNotThere)
{    return getCapability(capability.toString(), errorIfNotThere);}
public Optional<Object> metron_f8902_0(String capability)
{    return getCapability(capability, true);}
public Optional<Object> metron_f8903_0(String capability, boolean errorIfNotThere)
{    Capability c = capabilities.get(capability);    if (c == null && errorIfNotThere) {        throw new IllegalStateException("Unable to find capability " + capability + "; it may not be available in your context.");    } else if (c == null) {        return Optional.empty();    }    return Optional.ofNullable(c.get());}
public void metron_f8904_0(String s, Capability capability)
{    this.capabilities.put(s, capability);}
public void metron_f8905_0(Enum<?> s, Capability capability)
{    this.capabilities.put(s.toString(), capability);}
public ActivityType metron_f8906_0()
{    return _activityType.get();}
public void metron_f8907_0(ActivityType activityType)
{    _activityType.set(activityType);}
public Object metron_f8908_0(String variable)
{    return resolveFunc.apply(variable);}
public boolean metron_f8909_0(String variable)
{    return existsFunc.apply(variable);}
public static DefaultVariableResolver metron_f8910_0()
{    return new DefaultVariableResolver(x -> null, x -> false);}
public void metron_f8911_0(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
{    throw new ParseException("Syntax error @ " + line + ":" + charPositionInLine + " " + msg, e);}
public Object metron_f8915_0(List<Object> strings)
{    return strings.get(0) == null ? null : ConversionUtils.convert(strings.get(0), clazz);}
public Object metron_f8916_0(List<Object> args)
{    BloomFilter<Object> filter = (BloomFilter) args.get(0);    for (int i = 1; i < args.size(); ++i) {        Object arg = args.get(i);        if (arg != null) {            filter.add(args.get(i));        }    }    return filter;}
public Object metron_f8917_0(List<Object> args)
{    if (args.size() == 0) {        return false;    }    BloomFilter<Object> filter = (BloomFilter) args.get(0);    if (args.size() > 1) {        Object arg = args.get(1);        if (arg == null) {            return false;        }        return filter.mightContain(arg);    }    return false;}
public Object metron_f8918_0(List<Object> args)
{    int expectedInsertions = 100000;    float falsePositiveRate = 0.01f;    if (args.size() > 1) {        expectedInsertions = ConversionUtils.convert(args.get(0), Integer.class);    }    if (args.size() > 2) {        falsePositiveRate = ConversionUtils.convert(args.get(1), Float.class);    }    return new BloomFilter<>(SerDeUtils.SERIALIZER, expectedInsertions, falsePositiveRate);}
public Object metron_f8919_0(List<Object> args)
{    if (args.size() > 0) {        Object firstArg = args.get(0);        if (firstArg instanceof List) {            BloomFilter ret = null;            for (Object bf : (List) firstArg) {                if (bf instanceof BloomFilter) {                    if (ret == null) {                        ret = (BloomFilter) bf;                    } else {                        ret.merge((BloomFilter) bf);                    }                }            }            return ret;        } else {            return null;        }    }    return null;}
public Object metron_f8920_0(List<Object> list)
{    if (null == list || list.size() == 0) {        return true;    }    Object o = list.get(0);    if (o instanceof Collection) {        return ((Collection) o).isEmpty();    } else if (o instanceof String) {        String val = (String) list.get(0);        return val == null || val.isEmpty() ? true : false;    } else if (o instanceof Map) {        return (((Map) o).isEmpty());    } else {        return o == null;    }}
public Object metron_f8921_0(List<Object> list)
{    if (list.size() == 0) {        return null;    }    Object o = list.get(0);    if (list.size() == 1) {        return o;    }    if (o instanceof List) {        List l = (List) o;        Object arg = list.get(1);        l.add(arg);        return l;    } else {        return o;    }}
public Object metron_f8922_0(List<Object> list)
{    if (list.size() == 0) {        return 0;    }    Object o = list.get(0);    if (o instanceof Collection) {        return ((Collection) o).size();    } else if (o instanceof Map) {        return ((Map) o).size();    } else if (o instanceof String) {        String val = (String) list.get(0);        return val == null || val.isEmpty() ? 0 : val.length();    } else {        return 0;    }}
public SimpleDateFormat metron_f8923_0()
{    return createFormat(format, timezone);}
public boolean metron_f8924_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    TimezonedFormat that = (TimezonedFormat) o;    if (format != null ? !format.equals(that.format) : that.format != null)        return false;    return timezone != null ? timezone.equals(that.timezone) : that.timezone == null;}
public int metron_f8925_0()
{    int result = format != null ? format.hashCode() : 0;    result = 31 * result + (timezone != null ? timezone.hashCode() : 0);    return result;}
public ThreadLocal<SimpleDateFormat> metron_f8926_0(final TimezonedFormat format) throws Exception
{    return new ThreadLocal<SimpleDateFormat>() {        @Override        public SimpleDateFormat initialValue() {            return format.toDateFormat();        }    };}
public SimpleDateFormat metron_f8927_0()
{    return format.toDateFormat();}
public static SimpleDateFormat metron_f8928_0(String format, Optional<String> timezone)
{    SimpleDateFormat sdf = new SimpleDateFormat(format);    if (timezone.isPresent()) {        sdf.setTimeZone(TimeZone.getTimeZone(timezone.get()));    }    return sdf;}
public static long metron_f8929_0(String date, String format, Optional<String> timezone) throws ExecutionException, ParseException
{    TimezonedFormat fmt;    if (timezone.isPresent()) {        fmt = new TimezonedFormat(format, timezone.get());    } else {        fmt = new TimezonedFormat(format);    }    SimpleDateFormat sdf = formatCache.get(fmt).get();    return sdf.parse(date).getTime();}
public static String metron_f8930_0(String format, Optional<Long> epochTime, Optional<String> timezone)
{    Long time = epochTime.orElseGet(System::currentTimeMillis);    TimezonedFormat fmt = timezone.map(s -> new TimezonedFormat(format, s)).orElseGet(() -> new TimezonedFormat(format));    SimpleDateFormat sdf = formatCache.get(fmt).get();    return sdf.format(new Date(time));}
public Object metron_f8931_0(List<Object> objects)
{    Object dateObj = objects.get(0);    Object formatObj = objects.get(1);    Object tzObj = null;    if (objects.size() >= 3) {        tzObj = objects.get(2);    }    if (dateObj != null && formatObj != null) {        try {            Optional<String> tz = (tzObj == null) ? Optional.empty() : Optional.of(tzObj.toString());            return getEpochTime(dateObj.toString(), formatObj.toString(), tz);        } catch (ExecutionException | ParseException e) {            return null;        }    }    return null;}
public Object metron_f8932_0(List<Object> objects)
{    int size = objects.size();    Optional<Object> formatObj = Optional.ofNullable(objects.get(0));    Optional<Long> epochObj = Optional.empty();    Optional<String> tzObj = Optional.empty();    if (size > 1) {        if (size == 2) {            if (objects.get(1) == null) {                return null;            }            epochObj = objects.get(1) instanceof Long ? Optional.of((Long) objects.get(1)) : Optional.empty();            tzObj = objects.get(1) instanceof String ? Optional.of((String) objects.get(1)) : Optional.empty();        } else {            epochObj = Optional.ofNullable((Long) objects.get(1));            tzObj = Optional.ofNullable((String) objects.get(2));        }    }    if (formatObj.isPresent()) {        return getDateFormat(formatObj.get().toString(), epochObj, tzObj);    } else {        return null;    }}
private static T metron_f8933_0(List<Object> args, int position, Class<T> clazz, T defaultValue)
{    T result = defaultValue;    if (args.size() > position) {        result = ConversionUtils.convert(args.get(position), clazz);    }    return result;}
public Object metron_f8934_0(List<Object> args)
{        Long epochMillis = getOrDefault(args, 0, Long.class, System.currentTimeMillis());    if (epochMillis == null) {                return null;    }        Calendar calendar = Calendar.getInstance();    calendar.setTimeInMillis(epochMillis);    return calendar.get(Calendar.DAY_OF_WEEK);}
public Object metron_f8935_0(List<Object> args)
{        Long epochMillis = getOrDefault(args, 0, Long.class, System.currentTimeMillis());    if (epochMillis == null) {                return null;    }        Calendar calendar = Calendar.getInstance();    calendar.setTimeInMillis(epochMillis);    return calendar.get(Calendar.DAY_OF_MONTH);}
public Object metron_f8936_0(List<Object> args)
{        Long epochMillis = getOrDefault(args, 0, Long.class, System.currentTimeMillis());    if (epochMillis == null) {                return null;    }        Calendar calendar = Calendar.getInstance();    calendar.setTimeInMillis(epochMillis);    return calendar.get(Calendar.WEEK_OF_MONTH);}
public Object metron_f8937_0(List<Object> args)
{        Long epochMillis = getOrDefault(args, 0, Long.class, System.currentTimeMillis());    if (epochMillis == null) {                return null;    }        Calendar calendar = Calendar.getInstance();    calendar.setTimeInMillis(epochMillis);    return calendar.get(Calendar.WEEK_OF_YEAR);}
public Object metron_f8938_0(List<Object> args)
{        Long epochMillis = getOrDefault(args, 0, Long.class, System.currentTimeMillis());    if (epochMillis == null) {                return null;    }        Calendar calendar = Calendar.getInstance();    calendar.setTimeInMillis(epochMillis);    return calendar.get(Calendar.MONTH);}
public Object metron_f8939_0(List<Object> args)
{        Long epochMillis = getOrDefault(args, 0, Long.class, System.currentTimeMillis());    if (epochMillis == null) {                return null;    }        Calendar calendar = Calendar.getInstance();    calendar.setTimeInMillis(epochMillis);    return calendar.get(Calendar.YEAR);}
public Object metron_f8940_0(List<Object> args)
{        Long epochMillis = getOrDefault(args, 0, Long.class, System.currentTimeMillis());    if (epochMillis == null) {                return null;    }        Calendar calendar = Calendar.getInstance();    calendar.setTimeInMillis(epochMillis);    return calendar.get(Calendar.DAY_OF_YEAR);}
public Object metron_f8941_0(List<Object> list)
{    return Encodings.SUPPORTED_LIST;}
public Object metron_f8942_0(List<Object> list)
{    if (list.size() < 2) {        throw new IllegalStateException("IS_ENCODING expects two args: [string, encoding] where encoding is one from " + "the supported list");    }    String str = (String) list.get(0);    String encoding = (String) list.get(1);    if (StringUtils.isEmpty(str) || StringUtils.isEmpty(encoding)) {        return false;    }    Encodings enc = null;    try {        enc = Encodings.valueOf(encoding.toUpperCase());    } catch (IllegalArgumentException iae) {        throw new IllegalStateException(String.format("Encoding %s not supported", encoding), iae);    }    return enc.is(str);}
public Object metron_f8943_0(List<Object> list)
{    if (list.size() != 2 && list.size() != 3) {        throw new IllegalStateException("DECODE expects two or three args: [string, encoding] or " + "[string, encoding, verify] where encoding is one from " + "the supported list");    }    Boolean verify = false;    String str = (String) list.get(0);    String encoding = (String) list.get(1);    if (list.size() == 3) {        verify = (Boolean) list.get(2);    }    if (StringUtils.isEmpty(str) || StringUtils.isEmpty(encoding)) {        return null;    }    Encodings enc = null;    try {        enc = Encodings.valueOf(encoding.toUpperCase());    } catch (IllegalArgumentException iae) {        throw new IllegalStateException(String.format("Encoding %s not supported", encoding), iae);    }    return enc.decode(str, verify);}
public Object metron_f8944_0(List<Object> list)
{    if (list.size() != 2 && list.size() != 3) {        throw new IllegalStateException("ENCODE expects two or three args: [string, encoding] where encoding is one from " + "the supported list");    }    String str = (String) list.get(0);    String encoding = (String) list.get(1);    if (StringUtils.isEmpty(str) || StringUtils.isEmpty(encoding)) {        return null;    }    Encodings enc = null;    try {        enc = Encodings.valueOf(encoding.toUpperCase());    } catch (IllegalArgumentException iae) {        throw new IllegalStateException(String.format("Encoding %s not supported", encoding), iae);    }    return enc.encode(str);}
public Object metron_f8945_0(List<Object> args)
{    Iterable<? extends Object> input = getIterable(args.get(0));    LambdaExpression expression = (LambdaExpression) args.get(1);    if (input == null || expression == null) {        return input;    }    List<Object> ret = new ArrayList<>();    for (Object o : input) {        ret.add(expression.apply(listOf(o)));    }    return ret;}
public Object metron_f8946_0(List<Object> args)
{    Iterable<? extends Object> input = getIterable(args.get(0));    LambdaExpression expression = (LambdaExpression) args.get(1);    if (input == null || expression == null) {        return input;    }    List<Object> ret = new ArrayList<>();    for (Object o : input) {        Object result = expression.apply(listOf(o));        if (result != null && result instanceof Boolean && (Boolean) result) {            ret.add(o);        }    }    return ret;}
public Object metron_f8947_0(List<Object> args)
{    Iterable<? extends Object> input = getIterable(args.get(0));    if (input == null || args.size() < 3) {        return null;    }    LambdaExpression expression = (LambdaExpression) args.get(1);    Object runningResult = args.get(2);    if (expression == null || runningResult == null) {        return null;    }    for (Object rhs : input) {        runningResult = expression.apply(listOf(runningResult, rhs));    }    return runningResult;}
private static Iterable<? extends Object> metron_f8948_0(Object o)
{    if (o == null) {        return null;    }    if (o instanceof String) {        return Lists.charactersOf((String) o);    } else if (o instanceof Iterable) {        return (Iterable<Object>) o;    } else {        throw new IllegalArgumentException(o.getClass() + " is not an iterable, and therefore cannot be used.");    }}
public Object metron_f8949_0(List<Object> args)
{    if (args == null || args.size() == 0) {        return new ArrayList<>();    }    return zip(args, true);}
public Object metron_f8950_0(List<Object> args)
{    if (args == null || args.size() == 0) {        return new ArrayList<>();    }    return zip(args, false);}
private static List<List<Object>> metron_f8951_0(List<Object> args, boolean jagged)
{    List<List<Object>> lists = new ArrayList<>();    Integer resultSize = null;    for (Object o : args) {        if (o instanceof List) {            List<Object> l = (List<Object>) o;            if (resultSize == null) {                resultSize = l.size();            } else if (jagged) {                resultSize = Math.max(l.size(), resultSize);            } else {                resultSize = Math.min(l.size(), resultSize);            }            lists.add(l);        }    }    if (resultSize == null) {        return new ArrayList<>();    }    return IntStream.range(0, resultSize).mapToObj(i -> {        List<Object> o = new ArrayList<>();        for (List<Object> list : lists) {            o.add(i < list.size() ? list.get(i) : null);        }        return o;    }).collect(Collectors.toList());}
private static List<Object> metron_f8952_0(Object... vals)
{    List<Object> ret = new ArrayList<>(vals.length);    for (int i = 0; i < vals.length; ++i) {        ret.add(vals[i]);    }    return ret;}
public List<String> metron_f8953_0(final List<Object> args)
{    if (args == null || args.size() != 0) {        throw new IllegalArgumentException("Invalid call. This function does not expect any arguments.");    }    List<String> ret = new ArrayList<>();    ret.addAll(HashStrategy.ALL_SUPPORTED_HASHES);    return ret;}
public Object metron_f8954_0(final List<Object> args)
{    if (args == null || args.size() < 2) {        throw new IllegalArgumentException("Invalid number of arguments: " + (args == null ? 0 : args.size()));    }    final Object toHash = args.get(0);    final Object hashType = args.get(1);    if (hashType == null) {        return null;    }    Map<String, Object> config = null;    if (args.size() > 2) {        Object configObj = args.get(2);        if (configObj instanceof Map && configObj != null) {            config = (Map<String, Object>) configObj;        }    }    try {        return HashStrategy.getHasher(hashType.toString(), Optional.ofNullable(config)).getHash(toHash);    } catch (final EncoderException e) {        return null;    } catch (final NoSuchAlgorithmException e) {        throw new IllegalArgumentException("Invalid hash type: " + hashType.toString());    }}
public Integer metron_f8955_0(final List<Object> args)
{    if (args == null || args.size() < 2) {        throw new IllegalArgumentException("Invalid call. This function requires at least 2 arguments: the two TLSH hashes.");    }    Object h1Obj = args.get(0);    Object h2Obj = args.get(1);    if (h1Obj != null && !(h1Obj instanceof String)) {        throw new IllegalArgumentException(h1Obj + " must be strings");    }    if (h2Obj != null && !(h2Obj instanceof String)) {        throw new IllegalArgumentException(h2Obj + " must be strings");    }    Optional<Boolean> includeLength = Optional.empty();    if (args.size() > 2) {        Object includeLengthArg = args.get(2);        if (includeLengthArg != null) {            includeLength = Optional.ofNullable(ConversionUtils.convert(includeLengthArg, Boolean.class));        }    }    return TLSH.distance(h1Obj == null ? null : h1Obj.toString(), h2Obj == null ? null : h2Obj.toString(), includeLength);}
public Object metron_f8956_0(List<Object> list)
{    if (list.size() < 2) {        return false;    }    Object key = list.get(0);    Object mapObj = list.get(1);    if (key != null && mapObj != null && mapObj instanceof Map) {        return ((Map) mapObj).containsKey(key);    }    return false;}
public Object metron_f8957_0(List<Object> objects)
{    Object keyObj = objects.get(0);    Object mapObj = objects.get(1);    Object defaultObj = null;    if (objects.size() >= 3) {        defaultObj = objects.get(2);    }    if (keyObj == null || mapObj == null) {        return defaultObj;    }    Map<Object, Object> map = (Map) mapObj;    Object ret = map.get(keyObj);    if (ret == null && defaultObj != null) {        return defaultObj;    }    return ret;}
public Object metron_f8958_0(List<Object> objects)
{    if (objects.size() < 3) {        throw new IllegalArgumentException("Must pass a key, value, and map");    } else {        Object keyObj = objects.get(0);        Object valueObj = objects.get(1);        Object mapObj = objects.get(2);        if (mapObj == null) {            mapObj = new HashMap<>();        }        Map<Object, Object> map = (Map) mapObj;        map.put(keyObj, valueObj);        return map;    }}
public Object metron_f8959_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashMap<Object, Object> ret = new LinkedHashMap<>();    Object o = list.get(0);    if (o != null) {        if (!(o instanceof Iterable)) {            throw new IllegalArgumentException("Expected an Iterable, but " + o + " is of type " + o.getClass());        }        Iterable<? extends Map> maps = (Iterable<? extends Map>) o;        if (Iterables.size(maps) == 1) {            return Iterables.getFirst(maps, null);        }        for (Map m : maps) {            if (m != null) {                ret.putAll(m);            }        }    }    return ret;}
public Object metron_f8960_0(List<Object> args)
{    if (args == null || args.size() != 1) {        throw new IllegalStateException("IS_NAN expects one: [number] ");    }    Object obj = args.get(0);    if (obj instanceof Number) {        return Double.isNaN(((Number) obj).doubleValue());    } else {        throw new ParseException("IS_NAN() expects a number argument");    }}
public Object metron_f8961_0(List<Object> list)
{    if (list.size() < 2) {        throw new IllegalStateException("IN_SUBNET expects at least two args: [ip, cidr1, cidr2, ...]" + " where cidr is the subnet mask in cidr form");    }    String ip = (String) list.get(0);    if (ip == null) {        return false;    }    boolean inSubnet = false;    for (int i = 1; i < list.size() && !inSubnet; ++i) {        String cidr = (String) list.get(i);        if (cidr == null) {            continue;        }        inSubnet |= new SubnetUtils(cidr).getInfo().isInRange(ip);    }    return inSubnet;}
public Object metron_f8962_0(List<Object> objects)
{    if (objects.isEmpty()) {        return null;    }    Object dnObj = objects.get(0);    InternetDomainName idn = toDomainName(dnObj);    if (idn != null) {        String dn = dnObj.toString();        String tld = extractTld(idn, dn);        if (!StringUtils.isEmpty(dn)) {            String suffix = safeSubstring(dn, 0, dn.length() - tld.length());            String hostnameWithoutTLD = safeSubstring(suffix, 0, suffix.length() - 1);            if (hostnameWithoutTLD == null) {                return dn;            }            String hostnameWithoutSubsAndTLD = Iterables.getLast(Splitter.on(".").split(hostnameWithoutTLD), null);            if (hostnameWithoutSubsAndTLD == null) {                return null;            }            return hostnameWithoutSubsAndTLD + "." + tld;        }    }    return null;}
public Object metron_f8963_0(List<Object> objects)
{    Object dnObj = objects.get(0);    InternetDomainName idn = toDomainName(dnObj);    if (idn != null) {        String dn = dnObj.toString();        String tld = extractTld(idn, dn);        String suffix = safeSubstring(dn, 0, dn.length() - tld.length());        if (StringUtils.isEmpty(suffix)) {            return suffix;        } else {            return suffix.substring(0, suffix.length() - 1);        }    }    return null;}
public Object metron_f8964_0(List<Object> objects)
{    Object dnObj = objects.get(0);    InternetDomainName idn = toDomainName(dnObj);    return extractTld(idn, dnObj + "");}
public Object metron_f8965_0(List<Object> objects)
{    URL url = toUrl(objects.get(0));    if (url == null) {        return null;    }    int port = url.getPort();    return port >= 0 ? port : url.getDefaultPort();}
public Object metron_f8966_0(List<Object> objects)
{    URL url = toUrl(objects.get(0));    return url == null ? null : url.getPath();}
public Object metron_f8967_0(List<Object> objects)
{    URL url = toUrl(objects.get(0));    return url == null ? null : url.getHost();}
public Object metron_f8968_0(List<Object> objects)
{    URL url = toUrl(objects.get(0));    return url == null ? null : url.getProtocol();}
private static String metron_f8969_0(InternetDomainName idn, String dn)
{    if (idn != null && idn.hasPublicSuffix()) {        String ret = idn.publicSuffix().toString();        if (ret.startsWith("InternetDomainName")) {            return Joiner.on(".").join(idn.publicSuffix().parts());        } else {            return ret;        }    } else if (dn != null) {        StringBuffer tld = new StringBuffer("");        for (int idx = dn.length() - 1; idx >= 0; idx--) {            char c = dn.charAt(idx);            if (c == '.') {                break;            } else {                tld.append(dn.charAt(idx));            }        }        return tld.reverse().toString();    } else {        return null;    }}
private static String metron_f8970_0(String val, int start, int end)
{    if (!StringUtils.isEmpty(val)) {        return val.substring(start, end);    }    return null;}
private static InternetDomainName metron_f8971_0(Object dnObj)
{    if (dnObj != null) {        if (dnObj instanceof String) {            String dn = dnObj.toString();            try {                return InternetDomainName.from(dn);            } catch (IllegalArgumentException iae) {                return null;            }        } else {            throw new IllegalArgumentException(dnObj + " is not a string and therefore also not a domain.");        }    }    return null;}
private static URL metron_f8972_0(Object urlObj)
{    if (urlObj == null) {        return null;    }    if (urlObj instanceof String) {        String url = urlObj.toString();        try {            return new URL(url);        } catch (MalformedURLException e) {            return null;        }    } else {        throw new IllegalArgumentException(urlObj + " is not a string and therefore also not a URL.");    }}
public Object metron_f8973_0(List<Object> args)
{    if (args.size() < 1 || args.get(0) == null) {        throw new IllegalStateException("MAX function requires at least one argument");    }    Object firstArg = args.get(0);    if (firstArg instanceof Ordinal) {        Ordinal stats = convert(firstArg, Ordinal.class);        return stats.getMax();    } else if (firstArg instanceof Iterable) {        Iterable<Comparable> list = (Iterable<Comparable>) args.get(0);        return orderList(list, (ret, val) -> ret.compareTo(val) < 0, "MAX");    } else {        throw new IllegalStateException("MAX function expects either 'a StatisticsProvider object' or 'Stellar list of values'");    }}
public Object metron_f8974_0(List<Object> args)
{    if (args.size() < 1 || args.get(0) == null) {        throw new IllegalStateException("MIN function requires at least one argument");    }    Object firstArg = args.get(0);    if (firstArg instanceof Ordinal) {        Ordinal stats = convert(firstArg, Ordinal.class);        return stats.getMin();    } else if (firstArg instanceof Iterable) {        Iterable<Comparable> list = (Iterable<Comparable>) args.get(0);        return orderList(list, (ret, val) -> ret.compareTo(val) > 0, "MIN");    } else {        throw new IllegalStateException("MIN function expects either 'a StatisticsProvider object' or 'Stellar list of values' ");    }}
private static Comparable metron_f8975_0(Iterable<Comparable> list, BiFunction<Comparable, Comparable, Boolean> eval, String funcName)
{    if (Iterables.isEmpty(list)) {        return null;    }    Object o = Iterables.getFirst(list, null);    Comparable ret = null;    for (Object valueVal : list) {        if (valueVal == null) {            continue;        }        Comparable value = null;        if (!(valueVal instanceof Comparable)) {            throw new IllegalStateException("Noncomparable object type " + valueVal.getClass().getName() + " submitted to " + funcName);        } else {            value = (Comparable) valueVal;        }        try {            Comparable convertedRet = ConversionUtils.convert(ret, value.getClass());            if (convertedRet == null && ret != null) {                throw new IllegalStateException("Incomparable objects were submitted to " + funcName + ": " + ret.getClass() + " is incomparable to " + value.getClass());            }            if (ret == null || eval.apply(convertedRet, value)) {                ret = value;            }        } catch (ClassCastException cce) {            throw new IllegalStateException("Incomparable objects were submitted to " + funcName + ": " + cce.getMessage(), cce);        }    }    return ret;}
public Object metron_f8976_0(List<Object> list)
{    if (list.size() < 2) {        throw new IllegalStateException("REGEXP_MATCH expects two args: [string, pattern] where pattern is a regexp pattern or a list of regexp patterns");    }    Object patternObject = list.get(1);    String str = (String) list.get(0);    if (str == null || patternObject == null) {        return false;    }    if (patternObject instanceof String) {        return PatternCache.INSTANCE.getPattern((String) patternObject).matcher(str).matches();    } else if (patternObject instanceof Iterable) {        boolean matches = false;        for (Object thisPatternObject : (Iterable) patternObject) {            if (thisPatternObject == null) {                continue;            }            if (PatternCache.INSTANCE.getPattern(thisPatternObject.toString()).matcher(str).matches()) {                matches = true;                break;            }        }        return matches;    }    return false;}
public Object metron_f8977_0(List<Object> list)
{    if (list.size() != 3) {        throw new IllegalStateException("REGEXP_GROUP_VAL expects three args: [string, pattern, int]" + "" + "where pattern is a regexp pattern");    }    String stringPattern = (String) list.get(1);    String str = (String) list.get(0);    Integer groupNumber = ConversionUtils.convert(list.get(2), Integer.class);    if (groupNumber == null) {                return null;    }    if (groupNumber == 0) {                return str;    }    if (str == null || stringPattern == null) {        return null;    }    Pattern pattern = PatternCache.INSTANCE.getPattern(stringPattern);    Matcher matcher = pattern.matcher(str);    if (!matcher.matches()) {        return null;    }    int groupCount = matcher.groupCount();    if (groupCount == 0 || groupCount < groupNumber) {        return null;    }    return matcher.group(groupNumber);}
public Object metron_f8978_0(List<Object> list)
{    if (list.size() != 3) {        throw new IllegalStateException("REGEXP_REPLACE expects three args: [string, pattern, value]" + " where pattern is a regexp pattern");    }    String str = (String) list.get(0);    String stringPattern = (String) list.get(1);    String value = (String) list.get(2);    if (StringUtils.isEmpty(str)) {        return null;    }    if (StringUtils.isEmpty(stringPattern) || StringUtils.isEmpty(value)) {        return str;    }    Pattern pattern = PatternCache.INSTANCE.getPattern(stringPattern);    Matcher matcher = pattern.matcher(str);    return matcher.replaceAll(value);}
public Iterable<StellarFunctionInfo> metron_f8979_0()
{    return functions.get().values();}
public Iterable<String> metron_f8980_0()
{    return functions.get().keySet();}
public void metron_f8981_0(Context context)
{    this.context = context;}
public void metron_f8982_1() throws IOException
{    if (!closed) {                Map<String, Throwable> errors = new HashMap<>();        for (StellarFunctionInfo info : getFunctionInfo()) {            try {                info.getFunction().close();            } catch (Throwable t) {                errors.put(info.getName(), t);            }        }        if (!errors.isEmpty()) {            StringBuilder sb = new StringBuilder();            sb.append("Unable to close Stellar functions:");            for (Map.Entry<String, Throwable> e : errors.entrySet()) {                Throwable throwable = e.getValue();                String eText = String.format("Exception - Function: %s; Message: %s; Cause: %s", e.getKey(), throwable.getMessage(), throwable.getCause());                sb.append(System.lineSeparator());                sb.append(eText);            }            closed = true;            throw new IOException(sb.toString());        }        closed = true;    } else {            }}
public StellarFunction metron_f8983_0(String functionName)
{    StellarFunctionInfo info = functions.get().get(functionName);    if (info == null) {        throw new IllegalStateException(format("Unknown function: `%s`", functionName));    }    return info.getFunction();}
public static StellarFunctionInfo metron_f8985_0(Class<? extends StellarFunction> clazz)
{    StellarFunctionInfo info = null;        if (clazz.isAnnotationPresent(Stellar.class)) {        Stellar annotation = clazz.getAnnotation(Stellar.class);        String fullyQualifiedName = getNameFromAnnotation(annotation);        StellarFunction function = createFunction(clazz);        if (fullyQualifiedName != null && function != null) {            info = new StellarFunctionInfo(annotation.description(), fullyQualifiedName, annotation.params(), annotation.returns(), function);        }    }    return info;}
public static String metron_f8986_0(Stellar annotation)
{        String name = annotation.name();    if (name == null || name.trim().length() == 0) {        return null;    } else {        name = name.trim();    }        String namespace = annotation.namespace();    if (namespace == null || namespace.length() == 0) {        namespace = null;    } else {        namespace = namespace.trim();    }    return Joiner.on("_").skipNulls().join(Arrays.asList(namespace, name));}
public static StellarFunction metron_f8987_1(Class<? extends StellarFunction> clazz)
{    try {        return clazz.getConstructor().newInstance();    } catch (Exception e) {                return null;    }}
public String metron_f8988_0()
{    return param;}
public Object metron_f8989_0(Map<String, Object> config)
{    return config.getOrDefault(param, defaultValue);}
public T metron_f8990_0(Map<String, Object> config, Class<T> clazz)
{    return ConversionUtils.convert(get(config), clazz);}
public void metron_f8991_0(ClassLoader... classloaders)
{    classLoaders.clear();    Arrays.stream(classloaders).forEach(c -> classLoaders.add(c));}
public void metron_f8992_0(String... toInclude)
{    for (String incl : toInclude) {        includes.add(incl);    }}
public void metron_f8993_0(String... toExclude)
{    for (String excl : toExclude) {        excludes.add(excl);    }}
protected Iterable<Class<?>> metron_f8995_0(ClassLoader cl)
{    return ClassIndex.getAnnotated(Stellar.class, cl);}
protected boolean metron_f8996_0(Class<?> c, FilterBuilder filterBuilder)
{    boolean isAssignable = StellarFunction.class.isAssignableFrom(c);    boolean isFiltered = filterBuilder.apply(c.getCanonicalName());    return isAssignable && isFiltered;}
public Set<Class<? extends StellarFunction>> metron_f8997_1()
{    ClassLoader[] cls = null;    if (this.classLoaders.size() == 0) {                cls = new ClassLoader[] { getClass().getClassLoader() };    } else {        List<ClassLoader> classLoaderList = new ArrayList<>();        for (int i = 0; i < this.classLoaders.size(); ++i) {            ClassLoader cl = this.classLoaders.get(i);            if (null != cl) {                                classLoaderList.add(cl);            } else {                            }        }        cls = classLoaderList.toArray(new ClassLoader[0]);    }    FilterBuilder filterBuilder = new FilterBuilder();    excludes.forEach(excl -> {        if (excl != null) {            filterBuilder.exclude(excl);        }    });    includes.forEach(incl -> {        if (incl != null) {            filterBuilder.include(incl);        }    });    Set<String> classes = new HashSet<>();    Set<Class<? extends StellarFunction>> ret = new HashSet<>();    for (ClassLoader cl : cls) {        for (Class<?> c : getStellarClasses(cl)) {            try {                                if (includeClass(c, filterBuilder)) {                    String className = c.getName();                    if (!classes.contains(className)) {                                                ret.add((Class<? extends StellarFunction>) c);                        classes.add(className);                    }                }            } catch (Error le) {                                try {                                    } catch (Error ie) {                                                        }            }        }    }    return ret;}
public Set<Class<? extends StellarFunction>> metron_f8999_0()
{    return classesToResolve;}
public SimpleFunctionResolver metron_f9000_0(Class<? extends StellarFunction> clazz)
{    this.classesToResolve.add(clazz);    return this;}
public static FunctionResolver metron_f9001_0()
{    return INSTANCE;}
public String metron_f9002_0()
{    return (String) get(BASIC_AUTH_USER);}
public String metron_f9003_0()
{    return (String) get(BASIC_AUTH_PASSWORD_PATH);}
public String metron_f9004_0()
{    return (String) get(PROXY_HOST);}
public Integer metron_f9005_0()
{    return (Integer) get(PROXY_PORT);}
public String metron_f9006_0()
{    return (String) get(PROXY_BASIC_AUTH_USER);}
public String metron_f9007_0()
{    return (String) get(PROXY_BASIC_AUTH_PASSWORD_PATH);}
public Integer metron_f9008_0()
{    return (Integer) get(TIMEOUT);}
public Integer metron_f9009_0()
{    return (Integer) get(CONNECT_TIMEOUT);}
public Integer metron_f9010_0()
{    return (Integer) get(CONNECTION_REQUEST_TIMEOUT);}
public Integer metron_f9011_0()
{    return (Integer) get(SOCKET_TIMEOUT);}
public List<Integer> metron_f9012_0()
{    return (List<Integer>) get(RESPONSE_CODES_ALLOWED);}
public Object metron_f9013_0()
{    return get(EMPTY_CONTENT_OVERRIDE);}
public Object metron_f9014_0()
{    return get(ERROR_VALUE_OVERRIDE);}
public Integer metron_f9015_0()
{    return (Integer) get(POOLING_MAX_TOTAL);}
public Integer metron_f9016_0()
{    return (Integer) get(POOLING_DEFAULT_MAX_PER_RUOTE);}
public Boolean metron_f9017_0()
{    return (Boolean) get(VERIFY_CONTENT_LENGTH);}
public Boolean metron_f9018_0()
{    return (Boolean) get(ENFORCE_JSON);}
private static synchronized void metron_f9019_0(Context context)
{    if (closeableHttpClient == null) {        closeableHttpClient = getHttpClient(context);    }}
private static synchronized void metron_f9020_0() throws IOException
{    if (closeableHttpClient != null) {        closeableHttpClient.close();        closeableHttpClient = null;    }}
private static synchronized void metron_f9021_0()
{    if (scheduledExecutorService == null) {        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();    }}
private static synchronized void metron_f9022_0()
{    if (scheduledExecutorService != null) {        scheduledExecutorService.shutdown();        scheduledExecutorService = null;    }}
public void metron_f9023_0(Context context)
{    initializeExecutorService();    initializeHttpClient(context);    initialized = true;}
public boolean metron_f9024_0()
{    return initialized;}
public Object metron_f9025_1(List<Object> args, Context context) throws ParseException
{    String uriString = getArg(0, String.class, args);    Map<String, Object> functionRestConfig = null;    Map<String, Object> queryParameters = new HashMap<>();    if (args.size() > 1) {        functionRestConfig = getArg(1, Map.class, args);        if (args.size() == 3) {            queryParameters = getArg(2, Map.class, args);        }    }        Map<String, Object> globalRestConfig = (Map<String, Object>) getGlobalConfig(context).get(STELLAR_REST_SETTINGS);    Map<String, Object> getRestConfig = (Map<String, Object>) getGlobalConfig(context).get(STELLAR_REST_GET_SETTINGS);    RestConfig restConfig = buildRestConfig(globalRestConfig, getRestConfig, functionRestConfig);    try {        HttpGet httpGet = buildGetRequest(uriString, queryParameters);        return executeRequest(restConfig, httpGet);    } catch (URISyntaxException e) {        throw new IllegalArgumentException(e.getMessage(), e);    } catch (IOException e) {                return restConfig.getErrorValueOverride();    }}
public void metron_f9026_0() throws IOException
{    closeHttpClient();    closeExecutorService();}
private HttpGet metron_f9027_0(String uri, Map<String, Object> queryParameters) throws URISyntaxException
{    HttpGet httpGet = new HttpGet(getURI(uri, queryParameters));    httpGet.addHeader("Accept", "application/json");    return httpGet;}
public void metron_f9028_0(Context context)
{    initializeExecutorService();    initializeHttpClient(context);    initialized = true;}
public boolean metron_f9029_0()
{    return initialized;}
public Object metron_f9030_1(List<Object> args, Context context) throws ParseException
{    String uriString = getArg(0, String.class, args);    Object dataObject = getArg(1, Object.class, args);    Map<String, Object> functionRestConfig = null;    Map<String, Object> queryParameters = new HashMap<>();    if (args.size() > 2) {        functionRestConfig = getArg(2, Map.class, args);        if (args.size() == 4) {            queryParameters = getArg(3, Map.class, args);        }    }        Map<String, Object> globalRestConfig = (Map<String, Object>) getGlobalConfig(context).get(STELLAR_REST_SETTINGS);    Map<String, Object> postRestConfig = (Map<String, Object>) getGlobalConfig(context).get(STELLAR_REST_POST_SETTINGS);    RestConfig restConfig = buildRestConfig(globalRestConfig, postRestConfig, functionRestConfig);    try {        HttpPost httpPost = buildPostRequest(restConfig, uriString, dataObject, queryParameters);        return executeRequest(restConfig, httpPost);    } catch (URISyntaxException e) {        throw new IllegalArgumentException(e.getMessage(), e);    } catch (IOException e) {                return restConfig.getErrorValueOverride();    }}
public void metron_f9031_0() throws IOException
{    closeHttpClient();    closeExecutorService();}
private HttpPost metron_f9032_0(RestConfig restConfig, String uriString, Object dataObject, Map<String, Object> queryParameters) throws JsonProcessingException, URISyntaxException, UnsupportedEncodingException
{    String body = getPostData(restConfig, dataObject);    URI uri = getURI(uriString, queryParameters);    HttpPost httpPost = new HttpPost(uri);    httpPost.setEntity(new StringEntity(body));    httpPost.addHeader("Accept", "application/json");    httpPost.addHeader("Content-type", "application/json");    return httpPost;}
private String metron_f9033_0(RestConfig restConfig, Object arg) throws JsonProcessingException
{    String data = "";    if (arg == null) {        return data;    }    if (arg instanceof Map) {        data = JSONUtils.INSTANCE.toJSON(arg, false);    } else {        data = arg.toString();        if (restConfig.enforceJson()) {            try {                JSONUtils.INSTANCE.toJSONObject(data);            } catch (org.json.simple.parser.ParseException e) {                throw new IllegalArgumentException(String.format("POST data '%s' must be properly formatted JSON.  " + "Set the '%s' property to false to disable this check.", data, RestConfig.ENFORCE_JSON));            }        }    }    return data;}
public static T metron_f9034_0(int index, Class<T> clazz, List<Object> args)
{    if (index >= args.size()) {        throw new IllegalArgumentException(format("Expected at least %d argument(s), found %d", index + 1, args.size()));    }    return ConversionUtils.convert(args.get(index), clazz);}
protected static CloseableHttpClient metron_f9035_0(Context context)
{    RestConfig restConfig = buildRestConfig(getGlobalConfig(context));    PoolingHttpClientConnectionManager cm = getConnectionManager(restConfig);    return HttpClients.custom().setConnectionManager(cm).build();}
protected static PoolingHttpClientConnectionManager metron_f9036_0(RestConfig restConfig)
{    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();    if (restConfig.containsKey(POOLING_MAX_TOTAL)) {        cm.setMaxTotal(restConfig.getPoolingMaxTotal());    }    if (restConfig.containsKey(POOLING_DEFAULT_MAX_PER_RUOTE)) {        cm.setDefaultMaxPerRoute(restConfig.getPoolingDefaultMaxPerRoute());    }    return cm;}
private static Map<String, Object> metron_f9037_0(Context context)
{    Optional<Object> globalCapability = context.getCapability(GLOBAL_CONFIG, false);    return globalCapability.map(o -> (Map<String, Object>) o).orElseGet(HashMap::new);}
protected static RestConfig metron_f9038_0(Map<String, Object>... configs)
{    RestConfig restConfig = new RestConfig();        for (Map<String, Object> config : configs) {        if (config != null) {            restConfig.putAll(config);        }    }    return restConfig;}
private static URI metron_f9039_0(String uriString, Map<String, Object> queryParameters) throws URISyntaxException
{    URIBuilder uriBuilder = new URIBuilder(uriString);    if (queryParameters != null) {        for (Map.Entry<String, Object> entry : queryParameters.entrySet()) {            uriBuilder.setParameter(entry.getKey(), (String) entry.getValue());        }    }    return uriBuilder.build();}
protected static Optional<HttpHost> metron_f9040_0(RestConfig restConfig)
{    Optional<HttpHost> proxy = Optional.empty();    if (restConfig.getProxyHost() != null && restConfig.getProxyPort() != null) {        proxy = Optional.of(new HttpHost(restConfig.getProxyHost(), restConfig.getProxyPort(), "http"));    }    return proxy;}
protected static RequestConfig metron_f9041_0(RestConfig restConfig, Optional<HttpHost> proxy)
{    RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();    if (restConfig.getConnectTimeout() != null) {        requestConfigBuilder.setConnectTimeout(restConfig.getConnectTimeout());    }    if (restConfig.getConnectionRequestTimeout() != null) {        requestConfigBuilder.setConnectionRequestTimeout(restConfig.getConnectionRequestTimeout());    }    if (restConfig.getSocketTimeout() != null) {        requestConfigBuilder.setSocketTimeout(restConfig.getSocketTimeout());    }    proxy.ifPresent(requestConfigBuilder::setProxy);    return requestConfigBuilder.build();}
protected static HttpClientContext metron_f9042_0(RestConfig restConfig, HttpHost target, Optional<HttpHost> proxy) throws IOException
{    HttpClientContext httpClientContext = HttpClientContext.create();    boolean credentialsAdded = false;    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();        if (restConfig.getBasicAuthUser() != null && restConfig.getBasicAuthPasswordPath() != null) {        String password = new String(readBytes(new Path(restConfig.getBasicAuthPasswordPath())), StandardCharsets.UTF_8);        credentialsProvider.setCredentials(new AuthScope(target), new UsernamePasswordCredentials(restConfig.getBasicAuthUser(), password));        credentialsAdded = true;    }        if (proxy.isPresent() && restConfig.getProxyBasicAuthUser() != null && restConfig.getProxyBasicAuthPasswordPath() != null) {        String password = new String(readBytes(new Path(restConfig.getProxyBasicAuthPasswordPath())), StandardCharsets.UTF_8);        credentialsProvider.setCredentials(new AuthScope(proxy.get()), new UsernamePasswordCredentials(restConfig.getProxyBasicAuthUser(), password));        credentialsAdded = true;    }    if (credentialsAdded) {        httpClientContext.setCredentialsProvider(credentialsProvider);    }    return httpClientContext;}
private static byte[] metron_f9043_0(Path inPath) throws IOException
{    FileSystem fs = FileSystem.get(inPath.toUri(), new Configuration());    try (FSDataInputStream inputStream = fs.open(inPath)) {        return IOUtils.toByteArray(inputStream);    }}
protected static Optional<Object> metron_f9045_0(RestConfig restConfig, HttpUriRequest httpUriRequest, HttpEntity httpEntity) throws IOException
{    Optional<Object> parsedResponse = Optional.empty();    if (httpEntity != null) {        int actualContentLength = 0;        String json = EntityUtils.toString(httpEntity);        if (json != null && !json.isEmpty()) {            actualContentLength = json.length();            parsedResponse = Optional.of(JSONUtils.INSTANCE.load(json, JSONUtils.MAP_SUPPLIER));        }        if (restConfig.verifyContentLength() && actualContentLength != httpEntity.getContentLength()) {            throw new IOException(String.format("Stellar REST request to %s returned incorrect or missing content length. " + "Content length in the response was %d but the actual body content length was %d.", httpUriRequest.getURI().toString(), httpEntity.getContentLength(), actualContentLength));        }    }    return parsedResponse;}
protected static void metron_f9046_0(CloseableHttpClient httpClient)
{    closeableHttpClient = httpClient;}
protected static void metron_f9047_0(ScheduledExecutorService executorService)
{    scheduledExecutorService = executorService;}
public Object metron_f9048_0(List<Object> list)
{    LinkedHashSet<Object> ret = new LinkedHashSet<>();    if (list.size() == 1) {        Object o = list.get(0);        if (o != null) {            if (o instanceof Iterable) {                Iterables.addAll(ret, (Iterable) o);            } else {                throw new IllegalArgumentException("Expected an Iterable, but " + o + " is of type " + o.getClass());            }        }    }    return ret;}
public Object metron_f9049_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashSet<Object> ret = (LinkedHashSet<Object>) list.get(0);    if (ret == null) {        ret = new LinkedHashSet<>();    }    for (int i = 1; i < list.size(); ++i) {        Object o = list.get(i);        if (o != null) {            ret.add(o);        }    }    return ret;}
public Object metron_f9050_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashSet<Object> ret = (LinkedHashSet<Object>) list.get(0);    if (ret == null) {        ret = new LinkedHashSet<>();    }    for (int i = 1; i < list.size(); ++i) {        Object o = list.get(i);        if (o != null) {            ret.remove(o);        }    }    return ret;}
public Object metron_f9051_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashSet<Object> ret = new LinkedHashSet<>();    Object o = list.get(0);    if (o != null) {        if (!(o instanceof Iterable)) {            throw new IllegalArgumentException("Expected an Iterable, but " + o + " is of type " + o.getClass());        }        Iterable<? extends Iterable> sets = (Iterable<? extends Iterable>) o;        for (Iterable s : sets) {            if (s != null) {                Iterables.addAll(ret, s);            }        }    }    return ret;}
public Object metron_f9052_0(List<Object> list)
{    LinkedHashMap<Object, Integer> ret = new LinkedHashMap<>();    if (list.size() >= 1) {        Object o = list.get(0);        if (o != null) {            if (!(o instanceof Iterable)) {                throw new IllegalArgumentException("Expected an Iterable, but " + o + " is of type " + o.getClass());            }            for (Object obj : (Iterable) o) {                ret.merge(obj, 1, (k, one) -> k + one);            }        }    }    return ret;}
public Object metron_f9053_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashMap<Object, Integer> ret = (LinkedHashMap<Object, Integer>) list.get(0);    if (ret == null) {        ret = new LinkedHashMap<>();    }    for (int i = 1; i < list.size(); ++i) {        Object o = list.get(i);        if (o != null) {            ret.merge(o, 1, (k, one) -> k + one);        }    }    return ret;}
public Object metron_f9054_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashMap<Object, Integer> ret = (LinkedHashMap<Object, Integer>) list.get(0);    if (ret == null) {        ret = new LinkedHashMap<>();    }    for (int i = 1; i < list.size(); ++i) {        Object o = list.get(i);        if (o != null) {            Integer cnt = ret.get(o);            if (cnt == null) {                continue;            }            if (cnt == 1) {                ret.remove(o);            } else {                ret.put(o, cnt - 1);            }        }    }    return ret;}
public Object metron_f9055_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashMap<Object, Integer> ret = new LinkedHashMap<>();    Iterable<Map<Object, Integer>> maps = (Iterable<Map<Object, Integer>>) list.get(0);    for (Map<Object, Integer> s : maps) {        if (s != null) {            for (Map.Entry<Object, Integer> kv : s.entrySet()) {                ret.merge(kv.getKey(), kv.getValue(), (k, cnt) -> k + cnt);            }        }    }    return ret;}
public Object metron_f9056_0(List<Object> list)
{    if (list.size() < 1) {        return null;    }    LinkedHashSet<Object> ret = new LinkedHashSet<>();    if (list.size() == 1) {        Map<Object, Integer> multiset = (Map<Object, Integer>) list.get(0);        if (multiset != null) {            ret.addAll(multiset.keySet());        }    }    return ret;}
private static Map<String, VariableResult> metron_f9057_0(Context context)
{    return (Map<String, VariableResult>) context.getCapability(Context.Capabilities.SHELL_VARIABLES).get();}
public Object metron_f9058_0(List<Object> args)
{    if (args.size() < 1) {        return null;    }    Map<Object, Object> map = (Map<Object, Object>) args.get(0);    if (map == null) {        map = new HashMap<>();    }    String[] headers = { "KEY", "VALUE" };    String[][] data = new String[map.size()][2];    int i = 0;    for (Map.Entry<Object, Object> kv : map.entrySet()) {        data[i++] = new String[] { kv.getKey().toString(), kv.getValue().toString() };    }    return FlipTable.of(headers, data);}
public Object metron_f9059_0(List<Object> args, Context context) throws ParseException
{    Map<String, VariableResult> variables = getVariables(context);    String[] headers = { "VARIABLE", "VALUE", "EXPRESSION" };    String[][] data = new String[variables.size()][3];    int wordWrap = -1;    if (args.size() > 0) {        wordWrap = ConversionUtils.convert(args.get(0), Integer.class);    }    int i = 0;    for (Map.Entry<String, VariableResult> kv : variables.entrySet()) {        VariableResult result = kv.getValue();        data[i++] = new String[] { toWrappedString(kv.getKey(), wordWrap), toWrappedString(result.getResult(), wordWrap), toWrappedString(result.getExpression().get(), wordWrap) };    }    return FlipTable.of(headers, data);}
private static String metron_f9060_0(Object o, int wrap)
{    String s = "" + o;    if (wrap <= 0) {        return s;    }    return WordUtils.wrap(s, wrap);}
public boolean metron_f9062_0()
{    return true;}
public Object metron_f9063_0(List<Object> args, Context context) throws ParseException
{    Map<String, VariableResult> variables = getVariables(context);    LinkedHashMap<String, String> ret = new LinkedHashMap<>();    for (Object arg : args) {        if (arg == null) {            continue;        }        String variable = (String) arg;        VariableResult result = variables.get(variable);        if (result != null && result.getExpression().isPresent()) {            ret.put(variable, result.getExpression().orElseGet(() -> ""));        }    }    return ret;}
public boolean metron_f9065_0()
{    return true;}
public Object metron_f9066_0(List<Object> args, Context context) throws ParseException
{    Map<String, VariableResult> variables = getVariables(context);    if (args.size() == 0) {        return null;    }    String variable = (String) args.get(0);    if (variable == null) {        return null;    }    VariableResult result = variables.get(variable);    if (result != null && result.getExpression().isPresent()) {        return result.getExpression().get();    }    return null;}
public boolean metron_f9068_0()
{    return true;}
private String metron_f9069_0()
{            String editor = System.getProperty("EDITOR");    if (org.apache.commons.lang3.StringUtils.isEmpty(editor)) {        editor = System.getenv().get("EDITOR");    }    if (org.apache.commons.lang3.StringUtils.isEmpty(editor)) {        editor = System.getenv("VISUAL");    }    if (org.apache.commons.lang3.StringUtils.isEmpty(editor)) {        editor = "/bin/vi";    }    return editor;}
public Object metron_f9070_1(List<Object> args, Context context) throws ParseException
{    File outFile = null;    String editor = getEditor();    try {        outFile = File.createTempFile("stellar_shell", "out");        if (args.size() > 0) {            String arg = (String) args.get(0);            try (PrintWriter pw = new PrintWriter(outFile, StandardCharsets.UTF_8.name())) {                IOUtils.write(arg, pw);            }        }    } catch (IOException e) {        String message = "Unable to create temp file: " + e.getMessage();                throw new IllegalStateException(message, e);    }    Optional<Object> console = context.getCapability(CONSOLE, false);    try {        PausableInput.INSTANCE.pause();                ProcessBuilder processBuilder = new ProcessBuilder(editor, outFile.getAbsolutePath());        processBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);        try {            Process p = processBuilder.start();                        p.waitFor();            try (BufferedReader br = Files.newBufferedReader(outFile.toPath(), StandardCharsets.UTF_8)) {                return IOUtils.toString(br).trim();            }        } catch (Exception e) {            String message = "Unable to read output: " + e.getMessage();                        return null;        }    } finally {        try {            PausableInput.INSTANCE.unpause();            if (console.isPresent()) {                ((Console) console.get()).pushToInputStream("\b\n");            }        } catch (IOException e) {                    }        if (outFile.exists()) {            outFile.delete();        }    }}
public boolean metron_f9072_0()
{    return true;}
public Object metron_f9073_0(List<Object> list)
{    if (list.size() < 2) {        throw new IllegalStateException("ENDS_WITH expects two args: [string, suffix] where suffix is the string fragment that the string should end with");    }    String prefix = (String) list.get(1);    String str = (String) list.get(0);    if (str == null || prefix == null) {        return false;    }    return str.endsWith(prefix);}
public Object metron_f9074_0(List<Object> list)
{    if (list.size() < 2) {        throw new IllegalStateException("STARTS_WITH expects two args: [string, prefix] where prefix is the string fragment that the string should start with");    }    String prefix = (String) list.get(1);    String str = (String) list.get(0);    if (str == null || prefix == null) {        return false;    }    return str.startsWith(prefix);}
public Object metron_f9075_0(List<Object> strings)
{    return strings.get(0) == null ? null : strings.get(0).toString().toLowerCase();}
public Object metron_f9076_0(List<Object> strings)
{    return strings.get(0) == null ? null : strings.get(0).toString().toUpperCase();}
public Object metron_f9077_0(List<Object> strings)
{    return strings.get(0) == null ? null : strings.get(0).toString();}
public Object metron_f9078_0(List<Object> strings)
{    return strings.get(0) == null ? null : strings.get(0).toString().trim();}
public Object metron_f9079_0(List<Object> args)
{    Iterable<Object> arg1 = (Iterable<Object>) args.get(0);    String delim = (String) args.get(1);    return Joiner.on(delim).join(Iterables.filter(arg1, x -> x != null));}
public Object metron_f9080_0(List<Object> args)
{    List ret = new ArrayList();    Object o1 = args.get(0);    if (o1 != null) {        String arg1 = o1.toString();        String delim = (String) args.get(1);        Iterables.addAll(ret, Splitter.on(delim).split(arg1));    }    return ret;}
public Object metron_f9081_0(List<Object> args)
{    List<Object> arg1 = (List<Object>) args.get(0);    return Iterables.getLast(arg1, null);}
public Object metron_f9082_0(List<Object> args)
{    List<Object> arg1 = (List<Object>) args.get(0);    return Iterables.getFirst(arg1, null);}
public Object metron_f9083_0(List<Object> args)
{    List<Object> arg1 = (List<Object>) args.get(0);    int offset = (Integer) args.get(1);    if (offset < arg1.size()) {        return Iterables.get(arg1, offset);    }    return null;}
public Object metron_f9084_0(List<Object> args)
{    if (args.size() < 3) {        throw new IllegalStateException("FILL_LEFT expects three args: [string,char,length] where char is the fill character string and length is the required length of the result");    }    return fill(FillDirection.LEFT, args.get(0), args.get(1), args.get(2));}
public Object metron_f9085_0(List<Object> args)
{    if (args.size() < 3) {        throw new IllegalStateException("FILL_RIGHT expects three args: [string,char,length] where char is the fill character string and length is the required length of the result");    }    return fill(FillDirection.RIGHT, args.get(0), args.get(1), args.get(2));}
private static Object metron_f9086_0(FillDirection direction, Object inputObject, Object fillObject, Object requiredLengthObject) throws ParseException
{    if (inputObject == null) {        return null;    }    String input = inputObject.toString();    if (requiredLengthObject == null || fillObject == null) {        throw new IllegalStateException("Required Length and Fill String are both required");    }    String fill = fillObject.toString();    if (org.apache.commons.lang.StringUtils.isEmpty(fill)) {        throw new IllegalStateException("The fill cannot be an empty string");    }    fill = fill.substring(0, 1);    Integer requiredLength = ConversionUtils.convert(requiredLengthObject, Integer.class);    if (requiredLength == null) {        throw new IllegalStateException("Required Length  not a valid Integer: " + requiredLengthObject.toString());    }    if (direction == FillDirection.LEFT) {        return org.apache.commons.lang.StringUtils.leftPad(input, requiredLength, fill);    }    return org.apache.commons.lang.StringUtils.rightPad(input, requiredLength, fill);}
public Object metron_f9087_0(List<Object> strings)
{    /*      Shannon entropy is defined as follows:      \Eta(X) = - \sum(p(x_i)*log_2(p(x_i)), i=0, n-1) where x_i are distinct characters in the string.       */    Map<Character, Integer> frequency = new HashMap<>();    if (strings.size() != 1) {        throw new IllegalArgumentException("STRING_ENTROPY expects exactly one argument which is a string.");    }    String input = ConversionUtils.convert(strings.get(0), String.class);    if (StringUtils.isEmpty(input)) {        return 0.0;    }    for (int i = 0; i < input.length(); ++i) {        char c = input.charAt(i);        frequency.put(c, frequency.getOrDefault(c, 0) + 1);    }    double ret = 0.0;    double log2 = Math.log(2);    for (Integer f : frequency.values()) {        double p = f.doubleValue() / input.length();        ret -= p * Math.log(p) / log2;    }    return ret;}
public Object metron_f9088_0(List<Object> args)
{    if (args.size() == 0) {        throw new IllegalArgumentException("[FORMAT] missing argument: format string");    }    String format = ConversionUtils.convert(args.get(0), String.class);    Object[] formatArgs = args.subList(1, args.size()).toArray();    return String.format(format, formatArgs);}
public Object metron_f9089_0(List<Object> strings)
{    if (strings == null || strings.size() < 2) {        throw new IllegalArgumentException("SUBSTRING requires (at least) 2 arguments: the input and the start position (inclusive)");    }    Object varObj = strings.get(0);    if (varObj != null && !(varObj instanceof String)) {        throw new IllegalArgumentException("SUBSTRING input must be a String");    }    String var = varObj == null ? null : (String) varObj;    Object startObj = strings.get(1);    if (startObj != null && !(startObj instanceof Number)) {        throw new IllegalArgumentException("SUBSTRING start must be an Number");    }    Integer start = startObj == null ? null : ((Number) startObj).intValue();    Integer end = null;    if (strings.size() > 2) {        Object endObj = strings.get(2);        if (endObj != null && !(endObj instanceof Number)) {            throw new IllegalArgumentException("SUBSTRING end must be an Number");        }        end = endObj == null ? null : ((Number) endObj).intValue();    }    if (var == null || start == null) {        return null;    } else if (var.length() == 0) {        return var;    } else {        if (end == null) {            return var.substring(start);        } else {            return var.substring(start, end);        }    }}
public Object metron_f9090_0(List<Object> strings)
{    if (strings == null || strings.size() == 0) {        throw new IllegalArgumentException("[CHOMP] missing argument: string to be chopped");    }    String var = strings.get(0) == null ? null : (String) strings.get(0);    if (var == null) {        return null;    } else if (var.length() == 0) {        return var;    } else {        return StringUtils.chomp(var);    }}
public Object metron_f9091_0(List<Object> strings)
{    if (strings == null || strings.size() == 0) {        throw new IllegalArgumentException("[CHOP] missing argument: string to be chopped");    }    String var = strings.get(0) == null ? null : (String) strings.get(0);    if (var == null) {        return null;    } else if (var.length() == 0) {        return var;    } else {        return StringUtils.chop(var);    }}
public Object metron_f9092_0(List<Object> strings)
{    String prefixed;    switch(strings.size()) {        case 2:            prefixed = StringUtils.prependIfMissing((String) strings.get(0), (String) strings.get(1));            break;        case 3:            prefixed = StringUtils.prependIfMissing((String) strings.get(0), (String) strings.get(1), (String) strings.get(2));            break;        default:            throw new IllegalArgumentException("[PREPEND_IF_MISSING] incorrect arguments: " + strings.toString() + "\nUsage: PREPEND_IF_MISSING <String> <prefix> [<prefix>...]");    }    return prefixed;}
public Object metron_f9093_0(List<Object> strings)
{    String suffixed;    switch(strings.size()) {        case 2:            suffixed = StringUtils.appendIfMissing((String) strings.get(0), (String) strings.get(1));            break;        case 3:            suffixed = StringUtils.appendIfMissing((String) strings.get(0), (String) strings.get(1), (String) strings.get(2));            break;        default:            throw new IllegalArgumentException("[APPEND_IF_MISSING] incorrect arguments. Usage: APPEND_IF_MISSING <String> <prefix> [<prefix>...]");    }    return suffixed;}
public Object metron_f9094_0(List<Object> strings)
{    if (strings.size() != 2) {        throw new IllegalArgumentException("[COUNT_MATCHES] incorrect arguments. Usage: COUNT_MATCHES <String> <substring>");    }    int matchcount;    matchcount = StringUtils.countMatches((String) strings.get(0), (String) strings.get(1));    return matchcount;}
public Object metron_f9095_0(List<Object> strings)
{    if (strings == null || strings.size() == 0) {        throw new IllegalArgumentException("[TO_JSON_OBJECT] incorrect arguments. Usage: TO_JSON_OBJECT <String>");    }    String var = (strings.get(0) == null) ? null : (String) strings.get(0);    if (var == null) {        return null;    } else if (var.length() == 0) {        return var;    } else {        if (!(strings.get(0) instanceof String)) {            throw new ParseException("Valid JSON string not supplied");        }                try {            return JSONUtils.INSTANCE.load((String) strings.get(0), Object.class);        } catch (JsonProcessingException ex) {            throw new ParseException("Valid JSON string not supplied", ex);        } catch (IOException e) {            e.printStackTrace();        }    }    return new ParseException("Unable to parse JSON string");}
public Object metron_f9096_0(List<Object> strings)
{    if (strings == null || strings.size() == 0) {        throw new IllegalArgumentException("[TO_JSON_MAP] incorrect arguments. Usage: TO_JSON_MAP <JSON String>");    }    String var = (strings.get(0) == null) ? null : (String) strings.get(0);    if (var == null) {        return null;    } else if (var.length() == 0) {        return var;    } else {        if (!(strings.get(0) instanceof String)) {            throw new ParseException("Valid JSON string not supplied");        }                String in = (String) strings.get(0);        try {            return (Map) JSONUtils.INSTANCE.load(in, JSONUtils.MAP_SUPPLIER);        } catch (JsonProcessingException ex) {            throw new ParseException(String.format("%s is not a valid JSON string", in), ex);        } catch (IOException ex) {            throw new ParseException(String.format("%s is not a valid JSON string", in), ex);        } catch (ClassCastException ex) {            throw new ParseException(String.format("%s is not a valid JSON string, expected a map", in), ex);        }    }}
public Object metron_f9097_0(List<Object> strings)
{    if (strings == null || strings.size() == 0) {        throw new IllegalArgumentException("[TO_JSON_LIST] incorrect arguments. Usage: TO_JSON_LIST <JSON String>");    }    String var = (strings.get(0) == null) ? null : (String) strings.get(0);    if (var == null) {        return null;    } else if (var.length() == 0) {        return var;    } else {        if (!(strings.get(0) instanceof String)) {            throw new ParseException("Valid JSON string not supplied");        }                String in = (String) strings.get(0);        try {            return (List) JSONUtils.INSTANCE.load(in, JSONUtils.LIST_SUPPLIER);        } catch (JsonProcessingException ex) {            throw new ParseException(String.format("%s is not a valid JSON string", in), ex);        } catch (IOException ex) {            throw new ParseException(String.format("%s is not a valid JSON string", in), ex);        } catch (ClassCastException ex) {            throw new ParseException(String.format("%s is not a valid JSON string, expected a list", in), ex);        }    }}
public Object metron_f9098_0(List<Object> args)
{    return extractTypeChecked(args, 0, String.class, x -> env.get((String) x.get(0)));}
public static Object metron_f9099_0(List<Object> args, int i, Class clazz, Function<List<Object>, Object> extractFunc)
{    if (args.size() < i + 1) {        return null;    } else if (clazz.isInstance(args.get(i))) {        return extractFunc.apply(args);    } else {        return null;    }}
public Object metron_f9100_0(List<Object> args)
{    return extractTypeChecked(args, 0, String.class, x -> System.getProperty((String) args.get(0)));}
public Object metron_f9101_0(List<Object> list)
{    return tagsList;}
public Object metron_f9102_0(List<Object> list)
{    if (list.size() < 3) {        throw new IllegalStateException("FUZZY_SCORE expects three args: [string, string, string]");    }    Object oterm = list.get(0);    Object oquery = list.get(1);    Object olang = list.get(2);        if (!(oterm instanceof String) || !(oquery instanceof String) || !(olang instanceof String)) {        return 0;    }    String term = (String) oterm;    String query = (String) oquery;    String lang = (String) olang;    if (!tagsList.contains(lang)) {        throw new ParseException("FUZZY_SCORE requires a valid IETF BCP47 language code see FUZZY_LANGS and https://tools.ietf.org/html/bcp47");    }    if (StringUtils.isEmpty(term) || StringUtils.isEmpty(query)) {        return 0;    }    Locale locale = Locale.forLanguageTag(lang);    FuzzyScore score = new FuzzyScore(locale);    return score.fuzzyScore(term, query);}
public static String metron_f9103_0(ParseTree tree)
{    return new AST(tree).toString();}
private Object metron_f9104_0(ParseTree tree)
{    if (tree.getChildCount() == 0) {        return tree.getPayload();    } else {        String ruleName = tree.getClass().getSimpleName().replace("Context", "");        return Character.toLowerCase(ruleName.charAt(0)) + ruleName.substring(1);    }}
private static void metron_f9105_0(ParseTree tree, AST ast)
{    if (tree.getChildCount() == 0) {        new AST(ast, tree);    } else if (tree.getChildCount() == 1) {        walk(tree.getChild(0), ast);    } else if (tree.getChildCount() > 1) {        for (int i = 0; i < tree.getChildCount(); i++) {            AST temp = new AST(ast, tree.getChild(i));            if (!(temp.payload instanceof Token)) {                walk(tree.getChild(i), temp);            }        }    }}
public String metron_f9106_0()
{    StringBuilder builder = new StringBuilder();    AST ast = this;    List<AST> firstStack = new ArrayList<>();    firstStack.add(ast);    List<List<AST>> childListStack = new ArrayList<>();    childListStack.add(firstStack);    while (!childListStack.isEmpty()) {        List<AST> childStack = childListStack.get(childListStack.size() - 1);        if (childStack.isEmpty()) {            childListStack.remove(childListStack.size() - 1);        } else {            ast = childStack.remove(0);            String caption;            if (ast.payload instanceof Token) {                Token token = (Token) ast.payload;                caption = String.format("TOKEN[type: %s, text: %s]", token.getType(), token.getText().replace("\n", "\\n"));            } else {                caption = String.valueOf(ast.payload);            }            String indent = "";            for (int i = 0; i < childListStack.size() - 1; i++) {                indent += (childListStack.get(i).size() > 0) ? "|  " : "   ";            }            builder.append(indent).append(childStack.isEmpty() ? "'- " : "|- ").append(caption).append("\n");            if (ast.children.size() > 0) {                List<AST> children = new ArrayList<>();                for (int i = 0; i < ast.children.size(); i++) {                    children.add(ast.children.get(i));                }                childListStack.add(children);            }        }    }    return builder.toString();}
public void metron_f9107_0(Map... ms)
{    if (ms != null) {        for (Map m : ms) {            if (m != null) {                this.variableMappings.add(m);            }        }    }}
public Object metron_f9108_0(String variable)
{    if (variable != null && variable.equals(VariableResolver.ALL_FIELDS)) {        return new ConcatMap(variableMappings);    }    for (Map variableMapping : variableMappings) {        Object o = variableMapping.get(variable);        if (o != null) {            return o;        }    }    return null;}
public boolean metron_f9109_0(String variable)
{    return true;}
public Object metron_f9110_0(List<Object> objects)
{    return pred.test(objects);}
public String metron_f9112_0()
{    return returns;}
public String metron_f9113_0()
{    return description;}
public String metron_f9114_0()
{    return name;}
public String[] metron_f9115_0()
{    return params;}
public StellarFunction metron_f9116_0()
{    return function;}
public boolean metron_f9117_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    StellarFunctionInfo that = (StellarFunctionInfo) o;    if (name != null ? !name.equals(that.name) : that.name != null)        return false;    if (description != null ? !description.equals(that.description) : that.description != null)        return false;    if (returns != null ? !returns.equals(that.returns) : that.returns != null)        return false;        if (!Arrays.equals(params, that.params))        return false;    return function != null ? function.equals(that.function) : that.function == null;}
public int metron_f9118_0()
{    int result = name != null ? name.hashCode() : 0;    result = 31 * result + (description != null ? description.hashCode() : 0);    result = 31 * result + (returns != null ? returns.hashCode() : 0);    result = 31 * result + Arrays.hashCode(params);    result = 31 * result + (function != null ? function.hashCode() : 0);    return result;}
public String metron_f9119_0()
{    return "StellarFunctionInfo{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", returns='" + returns + '\'' + ", params=" + Arrays.toString(params) + ", function=" + function + '}';}
public static FunctionResolver metron_f9120_0()
{    return SingletonFunctionResolver.getInstance();}
public static void metron_f9121_0(Context context)
{    SingletonFunctionResolver.getInstance().initialize(context);}
public static void metron_f9122_0() throws IOException
{    SingletonFunctionResolver.getInstance().close();}
public FrameContext.Context metron_f9123_0()
{    return multiArgContext;}
public T metron_f9124_0()
{    return value;}
public Class<T> metron_f9125_0()
{    return underlyingType;}
public String metron_f9126_0()
{    return "" + value;}
public boolean metron_f9127_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Token<?> token = (Token<?>) o;    if (getValue() != null ? !getValue().equals(token.getValue()) : token.getValue() != null)        return false;    return getUnderlyingType() != null ? getUnderlyingType().equals(token.getUnderlyingType()) : token.getUnderlyingType() == null;}
public int metron_f9128_0()
{    int result = getValue() != null ? getValue().hashCode() : 0;    result = 31 * result + (getUnderlyingType() != null ? getUnderlyingType().hashCode() : 0);    return result;}
public void metron_f9129_0() throws Exception
{    processor = new BaseStellarProcessor<>(Object.class);}
public void metron_f9130_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage("Unable to parse ': ");    processor.validate("'", true, Context.EMPTY_CONTEXT());}
public void metron_f9131_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage("Unable to parse ': ");    processor.validate("'", Context.EMPTY_CONTEXT());}
public void metron_f9132_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage("Unable to parse ': ");    processor.validate("'");}
public void metron_f9133_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage(" Unable to resolve function named 'UNKNOWN_FUNCTION'.");    assertTrue(processor.validate("1 < UNKNOWN_FUNCTION(3)", Context.EMPTY_CONTEXT()));}
public void metron_f9134_0() throws Exception
{    assertTrue(processor.validate("unknown_variable\n\n"));    assertTrue(processor.validate("unknown_variable > 2", Context.EMPTY_CONTEXT()));}
public void metron_f9135_0() throws Exception
{    assertFalse(processor.validate("true †", false, Context.EMPTY_CONTEXT()));    assertFalse(processor.validate("¢ (1 + 2)", false, Context.EMPTY_CONTEXT()));}
public void metron_f9136_0() throws Exception
{        Map<String, Object> cacheConfig = ImmutableMap.of(CachingStellarProcessor.MAX_CACHE_SIZE_PARAM, 2, CachingStellarProcessor.MAX_TIME_RETAIN_PARAM, 10, CachingStellarProcessor.RECORD_STATS, true);    cache = CachingStellarProcessor.createCache(cacheConfig);    contextWithCache = new Context.Builder().with(Context.Capabilities.CACHE, () -> cache).build();        processor = new CachingStellarProcessor();}
public void metron_f9137_0()
{    Object result = execute("TO_UPPER(name)", contextWithCache);    assertEquals("BLAH", result);    assertEquals(1, cache.stats().requestCount());    assertEquals(1, cache.stats().missCount());    assertEquals(0, cache.stats().hitCount());    result = execute("TO_UPPER(name)", contextWithCache);    assertEquals("BLAH", result);    assertEquals(2, cache.stats().requestCount());    assertEquals(1, cache.stats().missCount());    assertEquals(1, cache.stats().hitCount());    result = execute("TO_UPPER(name)", contextWithCache);    assertEquals("BLAH", result);    assertEquals(3, cache.stats().requestCount());    assertEquals(1, cache.stats().missCount());    assertEquals(2, cache.stats().hitCount());}
public void metron_f9138_0() throws Exception
{        Context contextNoCache = Context.EMPTY_CONTEXT();    assertEquals("BLAH", execute("TO_UPPER(name)", contextNoCache));    assertEquals("BLAH", execute("TO_UPPER(name)", contextNoCache));}
public void metron_f9139_0()
{    Map<String, Object> cacheConfig = ImmutableMap.of(CachingStellarProcessor.MAX_CACHE_SIZE_PARAM, -1, CachingStellarProcessor.MAX_TIME_RETAIN_PARAM, 10);    cache = CachingStellarProcessor.createCache(cacheConfig);    assertNull(cache);}
public void metron_f9140_0()
{    Map<String, Object> cacheConfig = ImmutableMap.of(CachingStellarProcessor.MAX_TIME_RETAIN_PARAM, 10);    cache = CachingStellarProcessor.createCache(cacheConfig);    assertNull(cache);}
public void metron_f9141_0()
{    Map<String, Object> cacheConfig = ImmutableMap.of(CachingStellarProcessor.MAX_CACHE_SIZE_PARAM, 10, CachingStellarProcessor.MAX_TIME_RETAIN_PARAM, -2);    cache = CachingStellarProcessor.createCache(cacheConfig);    assertNull(cache);}
public void metron_f9142_0()
{    Map<String, Object> cacheConfig = ImmutableMap.of(CachingStellarProcessor.MAX_CACHE_SIZE_PARAM, 10);    cache = CachingStellarProcessor.createCache(cacheConfig);    assertNull(cache);}
public void metron_f9143_0()
{        Object result = execute("TO_UPPER(name)", contextWithCache);    assertEquals("BLAH", result);    assertEquals(1, cache.stats().requestCount());    assertEquals(1, cache.stats().missCount());    assertEquals(0, cache.stats().hitCount());        fields.put("unrelated_var_1", "true");    fields.put("unrelated_var_2", 22);        result = execute("TO_UPPER(name)", contextWithCache);    assertEquals("BLAH", result);    assertEquals(2, cache.stats().requestCount());    assertEquals(1, cache.stats().missCount());    assertEquals(1, cache.stats().hitCount());}
private Object metron_f9144_0(String expression, Context context)
{    Object result = processor.parse(expression, new MapVariableResolver(fields), StellarFunctions.FUNCTION_RESOLVER(), context);    return result;}
public void metron_f9145_0() throws ParseException
{        JSONParser parser = new JSONParser();    message = (JSONObject) parser.parse(input);        executor = new DefaultStellarStatefulExecutor();    executor.setContext(Context.EMPTY_CONTEXT());    ClasspathFunctionResolver resolver = new ClasspathFunctionResolver();    executor.setFunctionResolver(resolver);}
public void metron_f9146_0()
{    executor.assign("foo", "2", message);        Object var = executor.getState().get("foo");    assertThat(var, instanceOf(Integer.class));    assertThat(var, equalTo(2));}
public void metron_f9147_0()
{    executor.assign("foo", "ip_src_addr", message);        Object var = executor.getState().get("foo");    assertThat(var, instanceOf(String.class));    assertThat(var, equalTo("10.0.0.1"));}
public void metron_f9148_0()
{    executor.assign("two", "2", message);    executor.assign("four", "4", message);    executor.assign("sum", "two + four", message);        Object var = executor.getState().get("sum");    assertEquals(6, var);}
public void metron_f9149_0()
{    executor.assign("two", "2", message);    executor.clearState();        assertThat(executor.getState().containsKey("two"), equalTo(false));}
public void metron_f9150_0()
{    String actual = executor.execute("TO_UPPER('lowercase')", message, String.class);    assertThat(actual, equalTo("LOWERCASE"));}
public void metron_f9151_0()
{    boolean actual = executor.execute("IS_INTEGER(2)", message, Boolean.class);    assertThat(actual, equalTo(true));}
public void metron_f9152_0()
{    executor.execute("2 + 2", message, Boolean.class);}
public void metron_f9153_0()
{    executor.execute("2", message, Double.class);    executor.execute("2", message, Float.class);    executor.execute("2", message, Short.class);    executor.execute("2", message, Long.class);}
public void metron_f9154_0() throws Exception
{        ByteArrayOutputStream bytes = new ByteArrayOutputStream();    new ObjectOutputStream(bytes).writeObject(executor);        new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray())).readObject();}
public void metron_f9155_0() throws Exception
{        Assert.assertTrue(Encodings.BASE32.is(BASE32_FIXTURE));    Assert.assertFalse(Encodings.BASE32.is(STRING_FIXTURE));        Assert.assertTrue(Encodings.BASE32HEX.is(BASE32HEX_FIXTURE));    Assert.assertFalse(Encodings.BASE32HEX.is(STRING_FIXTURE));        Assert.assertTrue(Encodings.BASE64.is(BASE64_FIXTURE));    Assert.assertFalse(Encodings.BASE64.is(STRING_FIXTURE + "\0"));        Assert.assertTrue(Encodings.BINARY.is(BINARY_FIXTURE));    Assert.assertFalse(Encodings.BINARY.is(STRING_FIXTURE));        Assert.assertTrue(Encodings.HEX.is(HEX_FIXTURE));    Assert.assertFalse(Encodings.HEX.is("AAA"));}
public void metron_f9156_0() throws Exception
{    Assert.assertEquals(STRING_FIXTURE, Encodings.BASE32.decode(BASE32_FIXTURE));    Assert.assertEquals(STRING_FIXTURE, Encodings.BASE32HEX.decode(BASE32HEX_FIXTURE));    Assert.assertEquals(STRING_FIXTURE, Encodings.BASE64.decode(BASE64_FIXTURE));    Assert.assertEquals(STRING_FIXTURE, Encodings.BINARY.decode(BINARY_FIXTURE));    Assert.assertEquals(STRING_FIXTURE, Encodings.HEX.decode(HEX_FIXTURE));        Assert.assertNotEquals(STRING_FIXTURE, Encodings.BASE32.decode(STRING_FIXTURE));    Assert.assertNotEquals(STRING_FIXTURE, Encodings.BASE32HEX.decode(STRING_FIXTURE));    Assert.assertNotEquals(STRING_FIXTURE, Encodings.BASE64.decode(STRING_FIXTURE));            Assert.assertEquals(STRING_FIXTURE, Encodings.BINARY.decode(STRING_FIXTURE));    Assert.assertEquals(STRING_FIXTURE, Encodings.HEX.decode(STRING_FIXTURE));}
public void metron_f9157_0() throws Exception
{    Assert.assertEquals(STRING_FIXTURE, Encodings.BASE32.decode(BASE32_FIXTURE, true));    Assert.assertEquals(STRING_FIXTURE, Encodings.BASE32HEX.decode(BASE32HEX_FIXTURE, true));    Assert.assertEquals(STRING_FIXTURE, Encodings.BASE64.decode(BASE64_FIXTURE, true));    Assert.assertEquals(STRING_FIXTURE, Encodings.BINARY.decode(BINARY_FIXTURE, true));    Assert.assertEquals(STRING_FIXTURE, Encodings.HEX.decode(HEX_FIXTURE, true));        Assert.assertEquals(STRING_FIXTURE, Encodings.BASE32.decode(STRING_FIXTURE, true));    Assert.assertEquals(STRING_FIXTURE, Encodings.BASE32HEX.decode(STRING_FIXTURE, true));        Assert.assertNotEquals(STRING_FIXTURE, Encodings.BASE64.decode(STRING_FIXTURE, true));        Assert.assertEquals(STRING_FIXTURE + "\0", Encodings.BASE64.decode(STRING_FIXTURE + "\0", true));    Assert.assertEquals(STRING_FIXTURE, Encodings.BINARY.decode(STRING_FIXTURE, true));    Assert.assertEquals(STRING_FIXTURE, Encodings.HEX.decode(STRING_FIXTURE, true));}
public void metron_f9158_0() throws Exception
{    Assert.assertEquals(BASE32_FIXTURE, Encodings.BASE32.encode(STRING_FIXTURE));    Assert.assertEquals(BASE32HEX_FIXTURE, Encodings.BASE32HEX.encode(STRING_FIXTURE));    Assert.assertEquals(BASE64_FIXTURE, Encodings.BASE64.encode(STRING_FIXTURE));    Assert.assertEquals(BINARY_FIXTURE, Encodings.BINARY.encode(STRING_FIXTURE));    Assert.assertEquals(HEX_FIXTURE, Encodings.HEX.encode(STRING_FIXTURE));}
public void metron_f9159_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Double> r = mock(Token.class);    when(r.getValue()).thenReturn(2D);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), p);    assertTrue(evaluated.getValue() instanceof Double);    assertEquals(3.0D, evaluated.getValue());}
public void metron_f9160_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), p);    assertTrue(evaluated.getValue() instanceof Integer);    assertEquals(3, evaluated.getValue());}
public void metron_f9161_0() throws Exception
{    Token<Float> l = mock(Token.class);    when(l.getValue()).thenReturn(1F);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), p);    assertTrue(evaluated.getValue() instanceof Float);    assertEquals(3F, evaluated.getValue());}
public void metron_f9162_0() throws Exception
{    Token<Long> l = mock(Token.class);    when(l.getValue()).thenReturn(1L);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), p);    assertTrue(evaluated.getValue() instanceof Long);    assertEquals(3L, evaluated.getValue());}
public void metron_f9163_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Double> r = mock(Token.class);    when(r.getValue()).thenReturn(2D);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.multiplication(null), p);    assertTrue(evaluated.getValue() instanceof Double);    assertEquals(2.0D, evaluated.getValue());}
public void metron_f9164_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.multiplication(null), p);    assertTrue(evaluated.getValue() instanceof Integer);    assertEquals(2, evaluated.getValue());}
public void metron_f9165_0() throws Exception
{    Token<Float> l = mock(Token.class);    when(l.getValue()).thenReturn(1F);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.multiplication(null), p);    assertTrue(evaluated.getValue() instanceof Float);    assertEquals(2F, evaluated.getValue());}
public void metron_f9166_0() throws Exception
{    Token<Long> l = mock(Token.class);    when(l.getValue()).thenReturn(1L);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.multiplication(null), p);    assertTrue(evaluated.getValue() instanceof Long);    assertEquals(2L, evaluated.getValue());}
public void metron_f9167_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Double> r = mock(Token.class);    when(r.getValue()).thenReturn(2D);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.subtraction(null), p);    assertTrue(evaluated.getValue() instanceof Double);    assertEquals(-1.0D, evaluated.getValue());}
public void metron_f9168_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.subtraction(null), p);    assertTrue(evaluated.getValue() instanceof Integer);    assertEquals(-1, evaluated.getValue());}
public void metron_f9169_0() throws Exception
{    Token<Float> l = mock(Token.class);    when(l.getValue()).thenReturn(1F);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.subtraction(null), p);    assertTrue(evaluated.getValue() instanceof Float);    assertEquals(-1F, evaluated.getValue());}
public void metron_f9170_0() throws Exception
{    Token<Long> l = mock(Token.class);    when(l.getValue()).thenReturn(1L);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.subtraction(null), p);    assertTrue(evaluated.getValue() instanceof Long);    assertEquals(-1L, evaluated.getValue());}
public void metron_f9171_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Double> r = mock(Token.class);    when(r.getValue()).thenReturn(2D);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), p);    assertTrue(evaluated.getValue() instanceof Double);    assertEquals(1 / 2D, evaluated.getValue());}
public void metron_f9172_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), p);    assertTrue(evaluated.getValue() instanceof Integer);    assertEquals(1 / 2, evaluated.getValue());}
public void metron_f9173_0() throws Exception
{    Token<Float> l = mock(Token.class);    when(l.getValue()).thenReturn(1F);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), p);    assertTrue(evaluated.getValue() instanceof Float);    assertEquals(0.5F, evaluated.getValue());}
public void metron_f9174_0() throws Exception
{    Token<Long> l = mock(Token.class);    when(l.getValue()).thenReturn(1L);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), p);    assertTrue(evaluated.getValue() instanceof Long);    assertEquals(0L, evaluated.getValue());}
public void metron_f9175_0() throws Exception
{    evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), null);}
public void metron_f9176_0() throws Exception
{    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(null, mock(Token.class));    evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), p);}
public void metron_f9177_0() throws Exception
{    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(mock(Token.class), null);    evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), p);}
public void metron_f9178_0() throws Exception
{    Token<Short> l = mock(Token.class);    when(l.getValue()).thenReturn((short) 2);    Token<Short> r = mock(Token.class);    when(r.getValue()).thenReturn((short) 3);    Token<? extends Number> evaluated0 = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), Pair.of(l, r));    Token<? extends Number> evaluated1 = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.subtraction(null), Pair.of(l, r));    Token<? extends Number> evaluated2 = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.multiplication(null), Pair.of(l, r));    Token<? extends Number> evaluated3 = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), Pair.of(l, r));    assertTrue(evaluated0.getValue() instanceof Integer);    assertEquals(5, evaluated0.getValue());    assertTrue(evaluated1.getValue() instanceof Integer);    assertEquals(-1, evaluated1.getValue());    assertTrue(evaluated2.getValue() instanceof Integer);    assertEquals(6, evaluated2.getValue());    assertTrue(evaluated3.getValue() instanceof Integer);    assertEquals(0, evaluated3.getValue());}
public void metron_f9179_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(null);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(2);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), p);    assertTrue(evaluated.getValue() instanceof Integer);    assertEquals(2, evaluated.getValue());}
public void metron_f9180_0() throws Exception
{    Token<Integer> l = mock(Token.class);    when(l.getValue()).thenReturn(1);    Token<Integer> r = mock(Token.class);    when(r.getValue()).thenReturn(null);    Pair<Token<? extends Number>, Token<? extends Number>> p = Pair.of(l, r);    Token<? extends Number> evaluated = evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), p);    assertTrue(evaluated.getValue() instanceof Integer);    assertEquals(1, evaluated.getValue());}
public void metron_f9181_0() throws Exception
{    Token<Integer> integer = mock(Token.class);    when(integer.getValue()).thenReturn(1);    Token<Long> lng = mock(Token.class);    when(lng.getValue()).thenReturn(1L);    Token<Double> dbl = mock(Token.class);    when(dbl.getValue()).thenReturn(1.0D);    Token<Float> flt = mock(Token.class);    when(flt.getValue()).thenReturn(1.0F);    Map<Pair<Token<? extends Number>, Token<? extends Number>>, Class<? extends Number>> expectedReturnTypeMappings = new HashMap<Pair<Token<? extends Number>, Token<? extends Number>>, Class<? extends Number>>() {        {            put(Pair.of(flt, lng), Float.class);            put(Pair.of(flt, dbl), Double.class);            put(Pair.of(flt, flt), Float.class);            put(Pair.of(flt, integer), Float.class);            put(Pair.of(lng, lng), Long.class);            put(Pair.of(lng, dbl), Double.class);            put(Pair.of(lng, flt), Float.class);            put(Pair.of(lng, integer), Long.class);            put(Pair.of(dbl, lng), Double.class);            put(Pair.of(dbl, dbl), Double.class);            put(Pair.of(dbl, flt), Double.class);            put(Pair.of(dbl, integer), Double.class);            put(Pair.of(integer, lng), Long.class);            put(Pair.of(integer, dbl), Double.class);            put(Pair.of(integer, flt), Float.class);            put(Pair.of(integer, integer), Integer.class);        }    };    expectedReturnTypeMappings.forEach((pair, expectedClass) -> {        assertTrue(evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.addition(null), pair).getValue().getClass() == expectedClass);        assertTrue(evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.division(null), pair).getValue().getClass() == expectedClass);        assertTrue(evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.subtraction(null), pair).getValue().getClass() == expectedClass);        assertTrue(evaluator.evaluate(ArithmeticEvaluator.ArithmeticEvaluatorFunctions.multiplication(null), pair).getValue().getClass() == expectedClass);    });}
public void metron_f9182_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(1D);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    Token<Boolean> evaluated = evaluator.evaluate(left, right, op, null);    assertTrue(evaluated.getValue());}
public void metron_f9183_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(1D);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.NEQ()).thenReturn(mock(TerminalNode.class));    Token<Boolean> evaluated = evaluator.evaluate(left, right, op, null);    assertFalse(evaluated.getValue());}
public void metron_f9184_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(0D);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.LTE()).thenReturn(mock(TerminalNode.class));    Token<Boolean> evaluated = evaluator.evaluate(left, right, op, null);    assertTrue(evaluated.getValue());}
public void metron_f9185_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage("Unsupported operations. The following expression is invalid: ");    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(0D);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    evaluator.evaluate(left, right, op, null);}
public void metron_f9186_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage("Unsupported operations. The following expression is invalid: ");    Token<String> left = mock(Token.class);    when(left.getValue()).thenReturn("adsf");    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.LTE()).thenReturn(mock(TerminalNode.class));    evaluator.evaluate(left, right, op, null);}
public void metron_f9187_0() throws Exception
{    evaluator = new ComparisonOperatorsEvaluator();}
public void metron_f9188_0() throws Exception
{    Token<String> left = mock(Token.class);    when(left.getValue()).thenReturn("b");    Token<String> right = mock(Token.class);    when(right.getValue()).thenReturn("a");    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    exception.expect(ParseException.class);    exception.expectMessage("Unsupported operator: " + op);    evaluator.evaluate(left, right, op);}
public void metron_f9189_0() throws Exception
{    Token<Long> left = mock(Token.class);    when(left.getValue()).thenReturn(1L);    Token<Long> right = mock(Token.class);    when(right.getValue()).thenReturn(0L);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    exception.expect(ParseException.class);    exception.expectMessage("Unsupported operator: " + op);    evaluator.evaluate(left, right, op);}
public void metron_f9190_0() throws Exception
{    Token<Long> left = mock(Token.class);    Token<Long> right = mock(Token.class);    when(right.getValue()).thenReturn(1L);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.LT()).thenReturn(mock(TerminalNode.class));    assertFalse(evaluator.evaluate(left, right, op));}
public void metron_f9191_0() throws Exception
{    Token<Long> left = mock(Token.class);    when(left.getValue()).thenReturn(1L);    Token<Long> right = mock(Token.class);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.LT()).thenReturn(mock(TerminalNode.class));    assertFalse(evaluator.evaluate(left, right, op));}
public void metron_f9192_0() throws Exception
{    Token<Long> left = mock(Token.class);    Token<Long> right = mock(Token.class);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.LT()).thenReturn(mock(TerminalNode.class));    assertFalse(evaluator.evaluate(left, right, op));}
public void metron_f9193_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage("Unsupported operations. The following expression is invalid: ");    Token<Serializable> left = mock(Token.class);    when(left.getValue()).thenReturn(mock(Serializable.class));    Token<Serializable> right = mock(Token.class);    when(right.getValue()).thenReturn(mock(Serializable.class));    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.LT()).thenReturn(mock(TerminalNode.class));    evaluator.evaluate(left, right, op);}
public void metron_f9194_0() throws Exception
{    Token<Long> left = mock(Token.class);    when(left.getValue()).thenReturn(0L);    Token<Long> right = mock(Token.class);    when(right.getValue()).thenReturn(1L);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }}
public void metron_f9195_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(0D);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }}
public void metron_f9196_0() throws Exception
{    Token<Float> left = mock(Token.class);    when(left.getValue()).thenReturn(0F);    Token<Float> right = mock(Token.class);    when(right.getValue()).thenReturn(1F);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }}
public void metron_f9197_0() throws Exception
{    Token<Integer> left = mock(Token.class);    when(left.getValue()).thenReturn(0);    Token<Integer> right = mock(Token.class);    when(right.getValue()).thenReturn(1);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }}
public void metron_f9198_0() throws Exception
{    Token<Long> left = mock(Token.class);    when(left.getValue()).thenReturn(1L);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1.0000001D);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertTrue(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertFalse(evaluator.evaluate(left, right, op));    }}
public void metron_f9199_0() throws Exception
{    final double leftValue = 1.0000001D;    final float rightValue = 1.0000001F;    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(leftValue);    Token<Float> right = mock(Token.class);    when(right.getValue()).thenReturn(rightValue);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue < rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue <= rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue > rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue >= rightValue, evaluator.evaluate(left, right, op));    }}
public void metron_f9200_0() throws Exception
{    final int leftValue = 1;    final float rightValue = 1.0000001F;    Token<Integer> left = mock(Token.class);    when(left.getValue()).thenReturn(leftValue);    Token<Float> right = mock(Token.class);    when(right.getValue()).thenReturn(rightValue);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue < rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue <= rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue > rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue >= rightValue, evaluator.evaluate(left, right, op));    }}
public void metron_f9201_0() throws Exception
{    final int leftValue = 1;    final float rightValue = 1.00000001F;    Token<Integer> left = mock(Token.class);    when(left.getValue()).thenReturn(leftValue);    Token<Float> right = mock(Token.class);    when(right.getValue()).thenReturn(rightValue);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue < rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue <= rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue > rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue >= rightValue, evaluator.evaluate(left, right, op));    }}
public void metron_f9202_0() throws Exception
{    final int leftValue = 1;    final long rightValue = 3L;    Token<Integer> left = mock(Token.class);    when(left.getValue()).thenReturn(leftValue);    Token<Long> right = mock(Token.class);    when(right.getValue()).thenReturn(rightValue);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue < rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue <= rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue > rightValue, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue >= rightValue, evaluator.evaluate(left, right, op));    }}
public void metron_f9203_0() throws Exception
{    final String leftValue = "a";    final String rightValue = "b";    Token<String> left = mock(Token.class);    when(left.getValue()).thenReturn(leftValue);    Token<String> right = mock(Token.class);    when(right.getValue()).thenReturn(rightValue);    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue.compareTo(rightValue) < 0, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.LTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue.compareTo(rightValue) <= 0, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GT()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue.compareTo(rightValue) > 0, evaluator.evaluate(left, right, op));    }    {        StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);        when(op.GTE()).thenReturn(mock(TerminalNode.class));        assertEquals(leftValue.compareTo(rightValue) >= 0, evaluator.evaluate(left, right, op));    }}
public void metron_f9204_0() throws Exception
{    evaluator = new DoubleLiteralEvaluator();    context = mock(StellarParser.DoubleLiteralContext.class);}
public void metron_f9205_0() throws Exception
{    when(context.getText()).thenReturn("100D");    Token<? extends Number> evaluated = evaluator.evaluate(context, null);    assertEquals(new Token<>(100D, Double.class, null), evaluated);    verify(context).getText();    verifyNoMoreInteractions(context);}
public void metron_f9206_0() throws Exception
{    exception.expect(NumberFormatException.class);    when(context.getText()).thenReturn("");    evaluator.evaluate(context, null);}
public void metron_f9207_0() throws Exception
{    exception.expect(IllegalArgumentException.class);    exception.expectMessage("Cannot evaluate a context that is null.");    evaluator.evaluate(null, null);}
public void metron_f9208_0() throws Exception
{    evaluator = new EqualityOperatorsEvaluator();}
public void metron_f9209_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(null);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(null);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    boolean evaluated = evaluator.evaluate(left, right, op);    assertTrue(evaluated);}
public void metron_f9210_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(null);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    boolean evaluated = evaluator.evaluate(left, right, op);    assertFalse(evaluated);}
public void metron_f9211_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(1D);    Token<Long> right = mock(Token.class);    when(right.getValue()).thenReturn(null);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    boolean evaluated = evaluator.evaluate(left, right, op);    assertFalse(evaluated);}
public void metron_f9212_0() throws Exception
{    Token<Long> left = mock(Token.class);    when(left.getValue()).thenReturn(1L);    Token<Long> right = mock(Token.class);    when(right.getValue()).thenReturn(1L);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    assertTrue(evaluator.evaluate(left, right, op));}
public void metron_f9213_0() throws Exception
{    Token<Double> left = mock(Token.class);    when(left.getValue()).thenReturn(1D);    Token<Double> right = mock(Token.class);    when(right.getValue()).thenReturn(1D);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    assertTrue(evaluator.evaluate(left, right, op));}
public void metron_f9214_0() throws Exception
{    Token<Float> left = mock(Token.class);    when(left.getValue()).thenReturn(1F);    Token<Float> right = mock(Token.class);    when(right.getValue()).thenReturn(1F);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    assertTrue(evaluator.evaluate(left, right, op));}
public void metron_f9215_0() throws Exception
{    Token<Integer> left = mock(Token.class);    when(left.getValue()).thenReturn(1);    Token<Integer> right = mock(Token.class);    when(right.getValue()).thenReturn(1);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    assertTrue(evaluator.evaluate(left, right, op));}
public void metron_f9216_0() throws Exception
{    Token<String> left = mock(Token.class);    when(left.getValue()).thenReturn("1");    Token<String> right = mock(Token.class);    when(right.getValue()).thenReturn("1");    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    assertTrue(evaluator.evaluate(left, right, op));}
public void metron_f9217_0() throws Exception
{    Token<String> left = mock(Token.class);    when(left.getValue()).thenReturn("1");    Token<Long> right = mock(Token.class);    when(right.getValue()).thenReturn(1L);    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    assertFalse(evaluator.evaluate(left, right, op));}
public void metron_f9218_0() throws Exception
{    Token<Long> left = mock(Token.class);    when(left.getValue()).thenReturn(1L);    Token<String> right = mock(Token.class);    when(right.getValue()).thenReturn("1");    StellarParser.ComparisonOpContext op = mock(StellarParser.ComparisonOpContext.class);    when(op.EQ()).thenReturn(mock(TerminalNode.class));    assertFalse(evaluator.evaluate(left, right, op));}
public void metron_f9219_0() throws Exception
{    evaluator = new FloatLiteralEvaluator();    context = mock(StellarParser.FloatLiteralContext.class);}
public void metron_f9220_0() throws Exception
{    when(context.getText()).thenReturn("100f");    Token<? extends Number> evaluated = evaluator.evaluate(context, null);    assertEquals(new Token<>(100f, Float.class, null), evaluated);    verify(context).getText();    verifyNoMoreInteractions(context);}
public void metron_f9221_0() throws Exception
{    exception.expect(NumberFormatException.class);    when(context.getText()).thenReturn("");    evaluator.evaluate(context, null);}
public void metron_f9222_0() throws Exception
{    exception.expect(IllegalArgumentException.class);    exception.expectMessage("Cannot evaluate a context that is null.");    evaluator.evaluate(null, null);}
public void metron_f9223_0() throws Exception
{    evaluator = new IntLiteralEvaluator();    context = mock(StellarParser.IntLiteralContext.class);}
public void metron_f9224_0() throws Exception
{    when(context.getText()).thenReturn("100");    Token<? extends Number> evaluated = evaluator.evaluate(context, null);    assertEquals(new Token<>(100, Integer.class, null), evaluated);    verify(context).getText();    verifyNoMoreInteractions(context);}
public void metron_f9225_0() throws Exception
{    exception.expect(NumberFormatException.class);    when(context.getText()).thenReturn("");    evaluator.evaluate(context, null);}
public void metron_f9226_0() throws Exception
{    exception.expect(IllegalArgumentException.class);    exception.expectMessage("Cannot evaluate a context that is null.");    evaluator.evaluate(null, null);}
public void metron_f9227_0() throws Exception
{    evaluator = new LongLiteralEvaluator();    context = mock(StellarParser.LongLiteralContext.class);}
public void metron_f9228_0() throws Exception
{    when(context.getText()).thenReturn("100L");    Token<? extends Number> evaluated = evaluator.evaluate(context, null);    assertEquals(new Token<>(100L, Long.class, null), evaluated);    verify(context).getText();    verifyNoMoreInteractions(context);}
public void metron_f9229_0() throws Exception
{    exception.expect(ParseException.class);    exception.expectMessage("Invalid format for long. Failed trying to parse a long with the following value: ");    when(context.getText()).thenReturn("");    evaluator.evaluate(context, null);}
public void metron_f9230_0() throws Exception
{    exception.expect(IllegalArgumentException.class);    exception.expectMessage("Cannot evaluate a context that is null.");    evaluator.evaluate(null, null);}
public void metron_f9231_0() throws Exception
{    intLiteralContextNumberEvaluator = mock(IntLiteralEvaluator.class);    doubleLiteralContextNumberEvaluator = mock(DoubleLiteralEvaluator.class);    floatLiteralContextNumberEvaluator = mock(FloatLiteralEvaluator.class);    longLiteralContextNumberEvaluator = mock(LongLiteralEvaluator.class);    instanceMap = new HashMap<Class<? extends StellarParser.Arithmetic_operandsContext>, NumberEvaluator>() {        {            put(mock(StellarParser.IntLiteralContext.class).getClass(), intLiteralContextNumberEvaluator);            put(mock(StellarParser.DoubleLiteralContext.class).getClass(), doubleLiteralContextNumberEvaluator);            put(mock(StellarParser.FloatLiteralContext.class).getClass(), floatLiteralContextNumberEvaluator);            put(mock(StellarParser.LongLiteralContext.class).getClass(), longLiteralContextNumberEvaluator);        }    };}
public void metron_f9232_0() throws Exception
{    StellarParser.IntLiteralContext context = mock(StellarParser.IntLiteralContext.class);    NumberLiteralEvaluator.INSTANCE.evaluate(context, instanceMap, null);    verify(intLiteralContextNumberEvaluator).evaluate(context, null);    verifyZeroInteractions(doubleLiteralContextNumberEvaluator, floatLiteralContextNumberEvaluator, longLiteralContextNumberEvaluator);}
public void metron_f9233_0() throws Exception
{    StellarParser.DoubleLiteralContext context = mock(StellarParser.DoubleLiteralContext.class);    NumberLiteralEvaluator.INSTANCE.evaluate(context, instanceMap, null);    verify(doubleLiteralContextNumberEvaluator).evaluate(context, null);    verifyZeroInteractions(intLiteralContextNumberEvaluator, floatLiteralContextNumberEvaluator, longLiteralContextNumberEvaluator);}
public void metron_f9234_0() throws Exception
{    StellarParser.FloatLiteralContext context = mock(StellarParser.FloatLiteralContext.class);    NumberLiteralEvaluator.INSTANCE.evaluate(context, instanceMap, null);    verify(floatLiteralContextNumberEvaluator).evaluate(context, null);    verifyZeroInteractions(doubleLiteralContextNumberEvaluator, intLiteralContextNumberEvaluator, longLiteralContextNumberEvaluator);}
public void metron_f9235_0() throws Exception
{    StellarParser.LongLiteralContext context = mock(StellarParser.LongLiteralContext.class);    NumberLiteralEvaluator.INSTANCE.evaluate(context, instanceMap, null);    verify(longLiteralContextNumberEvaluator).evaluate(context, null);    verifyZeroInteractions(doubleLiteralContextNumberEvaluator, floatLiteralContextNumberEvaluator, intLiteralContextNumberEvaluator);}
public void metron_f9236_0() throws Exception
{    StellarParser.VariableContext context = mock(StellarParser.VariableContext.class);    exception.expect(ParseException.class);    exception.expectMessage("Does not support evaluation for type " + context.getClass());    NumberLiteralEvaluator.INSTANCE.evaluate(context, instanceMap, null);    verifyZeroInteractions(longLiteralContextNumberEvaluator, doubleLiteralContextNumberEvaluator, floatLiteralContextNumberEvaluator, intLiteralContextNumberEvaluator);}
public void metron_f9237_0()
{    runWithArguments("IN_SUBNET", ImmutableList.of("192.168.0.1", "192.168.0.0/24"), true);}
public void metron_f9238_0()
{    runWithArguments("IN_SUBNET", ImmutableList.of("192.168.1.1", "192.168.0.0/24"), false);}
public void metron_f9239_0()
{    runWithArguments("IN_SUBNET", ImmutableList.of("192.168.1.1", "192.168.0.0/24", "192.168.1.0/24"), true);}
public void metron_f9240_0()
{    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "www.google.co.uk", "google.co.uk");    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "www.google.com", "google.com");    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "com", "com");}
public void metron_f9241_0()
{    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "com.com", "com.com");    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "net.net", "net.net");    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "co.uk.co.uk", "uk.co.uk");    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "www.subdomain.com.com", "com.com");}
public void metron_f9242_0()
{    runWithArguments("DOMAIN_REMOVE_SUBDOMAINS", "www.subdomain.google.gmail", "google.gmail");}
public void metron_f9243_0()
{    runWithArguments("DOMAIN_TO_TLD", "www.google.co.uk", "co.uk");    runWithArguments("DOMAIN_TO_TLD", "www.google.com", "com");    runWithArguments("DOMAIN_TO_TLD", "com", "com");}
public void metron_f9244_0()
{    runWithArguments("DOMAIN_TO_TLD", "com.com", "com");    runWithArguments("DOMAIN_TO_TLD", "net.net", "net");    runWithArguments("DOMAIN_TO_TLD", "co.uk.co.uk", "co.uk");    runWithArguments("DOMAIN_TO_TLD", "www.subdomain.com.com", "com");}
public void metron_f9245_0()
{    runWithArguments("DOMAIN_TO_TLD", "www.subdomain.google.gmail", "gmail");}
public void metron_f9246_0()
{    runWithArguments("DOMAIN_REMOVE_TLD", "google.com", "google");    runWithArguments("DOMAIN_REMOVE_TLD", "www.google.co.uk", "www.google");    runWithArguments("DOMAIN_REMOVE_TLD", "www.google.com", "www.google");    runWithArguments("DOMAIN_REMOVE_TLD", "com", "");}
public void metron_f9247_0()
{    runWithArguments("DOMAIN_REMOVE_TLD", "com.com", "com");    runWithArguments("DOMAIN_REMOVE_TLD", "net.net", "net");    runWithArguments("DOMAIN_REMOVE_TLD", "co.uk.co.uk", "co.uk");    runWithArguments("DOMAIN_REMOVE_TLD", "www.subdomain.com.com", "www.subdomain.com");}
public void metron_f9248_0()
{    runWithArguments("DOMAIN_REMOVE_TLD", "www.subdomain.google.gmail", "www.subdomain.google");}
public void metron_f9249_0()
{    runWithArguments("URL_TO_PORT", "http://www.google.com/foo/bar", 80);    runWithArguments("URL_TO_PORT", "https://www.google.com/foo/bar", 443);    runWithArguments("URL_TO_PORT", "http://www.google.com:7979/foo/bar", 7979);}
public void metron_f9250_0()
{    runWithArguments("URL_TO_PORT", "http://www.google.gmail/foo/bar", 80);}
public void metron_f9251_0()
{    runWithArguments("URL_TO_HOST", "http://www.google.com/foo/bar", "www.google.com");    runWithArguments("URL_TO_HOST", "https://www.google.com/foo/bar", "www.google.com");    runWithArguments("URL_TO_HOST", "http://www.google.com:7979/foo/bar", "www.google.com");    runWithArguments("URL_TO_HOST", "http://localhost:8080/a", "localhost");}
public void metron_f9252_0()
{    runWithArguments("URL_TO_HOST", "http://www.google.gmail/foo/bar", "www.google.gmail");}
public void metron_f9253_0()
{    runWithArguments("URL_TO_PROTOCOL", "http://www.google.com/foo/bar", "http");    runWithArguments("URL_TO_PROTOCOL", "https://www.google.com/foo/bar", "https");}
public void metron_f9254_0()
{    runWithArguments("URL_TO_PROTOCOL", "http://www.google.gmail/foo/bar", "http");}
public void metron_f9255_0()
{    runWithArguments("URL_TO_PATH", "http://www.google.com/foo/bar", "/foo/bar");    runWithArguments("URL_TO_PATH", "https://www.google.com/foo/bar", "/foo/bar");}
public void metron_f9256_0()
{    runWithArguments("URL_TO_PATH", "http://www.google.gmail/foo/bar", "/foo/bar");}
public void metron_f9257_0() throws Exception
{    String[] validZHostArg = new String[] { "-z", "localhost:8888" };    String[] validZHostArgNoPort = new String[] { "-z", "localhost" };    String[] validZIPArgNoPort = new String[] { "-z", "10.10.10.3" };    String[] validZHostArgList = new String[] { "-z", "localhost:8888,localhost:2181,localhost" };    String[] validZIPArg = new String[] { "-z", "10.10.10.3:9999" };    String[] invalidZNameArg = new String[] { "-z", "!!!@!!@!:8882" };    String[] invalidZIPArg = new String[] { "-z", "11111.22222.10.3:3332" };    String[] invalidZMissingNameArg = new String[] { "-z", ":8882" };    String[] invalidZZeroPortArg = new String[] { "-z", "youtube.com:0" };    String[] invalidZHugePortArg = new String[] { "-z", "youtube.com:75565" };    String existingFileName = "./target/existsFile";    String nonExistentFile = "./target/doesNotExist";    String[] validVFileArg = new String[] { "-v", existingFileName };    String[] validIrcFileArg = new String[] { "-irc", existingFileName };    String[] validPFileArg = new String[] { "-p", existingFileName };    String[] invalidVFileArg = new String[] { "-v", nonExistentFile };    String[] invalidIrcFileArg = new String[] { "-irc", nonExistentFile };    String[] invalidPFileArg = new String[] { "-p", nonExistentFile };    File existingFile = new File(existingFileName);    if (!existingFile.exists()) {        existingFile.createNewFile();    }    Options options = new Options();    options.addOption("z", "zookeeper", true, "Zookeeper URL");    options.addOption("v", "variables", true, "File containing a JSON Map of variables");    options.addOption("irc", "inputrc", true, "File containing the inputrc if not the default ~/.inputrc");    options.addOption("na", "no_ansi", false, "Make the input prompt not use ANSI colors.");    options.addOption("h", "help", false, "Print help");    options.addOption("p", "properties", true, "File containing Stellar properties");    CommandLineParser parser = new PosixParser();        CommandLine commandLine = parser.parse(options, validZHostArg);    StellarShellOptionsValidator.validateOptions(commandLine);    commandLine = parser.parse(options, validZIPArg);    StellarShellOptionsValidator.validateOptions(commandLine);    commandLine = parser.parse(options, validVFileArg);    StellarShellOptionsValidator.validateOptions(commandLine);    commandLine = parser.parse(options, validIrcFileArg);    StellarShellOptionsValidator.validateOptions(commandLine);    commandLine = parser.parse(options, validPFileArg);    StellarShellOptionsValidator.validateOptions(commandLine);    commandLine = parser.parse(options, validZHostArgNoPort);    StellarShellOptionsValidator.validateOptions(commandLine);    commandLine = parser.parse(options, validZHostArgList);    StellarShellOptionsValidator.validateOptions(commandLine);    commandLine = parser.parse(options, validZIPArgNoPort);    StellarShellOptionsValidator.validateOptions(commandLine);        boolean thrown = false;    try {        commandLine = parser.parse(options, invalidZNameArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for providing invalid host name ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidZIPArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for providing invalid ip address ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidZMissingNameArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for only providing port ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidZZeroPortArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for 0 port ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidZHugePortArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for port out of range ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidVFileArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for passing non-existant file to -v ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidVFileArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for passing non-existant file to -v ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidIrcFileArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for passing non-existant file to -irc ", thrown);    thrown = false;    try {        commandLine = parser.parse(options, invalidPFileArg);        StellarShellOptionsValidator.validateOptions(commandLine);    } catch (IllegalArgumentException e) {        thrown = true;    }    Assert.assertTrue("Did not catch failure for passing non-existant file to -p ", thrown);    thrown = false;}
public void metron_f9258_0() throws Exception
{    out = new ByteArrayOutputStream();    err = new ByteArrayOutputStream();        System.setOut(new PrintStream(out, false, StandardCharsets.UTF_8.name()));    System.setErr(new PrintStream(err, false, StandardCharsets.UTF_8.name()));    String[] args = new String[0];    stellarShell = new StellarShell(args);}
public void metron_f9259_0()
{    System.setOut(null);    System.setErr(null);}
private String metron_f9260_0()
{    return out.toString().replace(System.lineSeparator(), "");}
private String metron_f9261_0()
{    return out.toString();}
private String metron_f9262_0()
{    return err.toString().replace(System.lineSeparator(), "");}
private ConsoleOperation metron_f9263_0(String buffer)
{    return new ConsoleOperation(ControlOperator.APPEND_OUT, buffer);}
public void metron_f9264_0() throws Exception
{    stellarShell.execute(createOp("2 + 2"));    assertEquals("4", stdout());}
public void metron_f9265_0() throws Exception
{    stellarShell.execute(createOp("SPLIT('foo\\\\bar', '\\\\')"));    assertEquals("[foo, bar]", stdout());}
public void metron_f9266_0() throws Exception
{    stellarShell.execute(createOp("[1,2,3,4,5]"));    assertEquals("[1, 2, 3, 4, 5]", stdout());}
public void metron_f9267_0() throws Exception
{    stellarShell.execute(createOp("{ 'foo':2, 'key':'val' }"));    assertEquals("{foo=2, key=val}", stdout());}
public void metron_f9268_0() throws Exception
{    stellarShell.execute(createOp("2 + "));    final String expected = "[!] Unable to parse: 2 + ";    assertTrue(stdout().startsWith(expected));}
public void metron_f9269_0() throws Exception
{    stellarShell.execute(createOp("x"));    assertEquals("", stdout());}
public void metron_f9270_0() throws Exception
{    stellarShell.execute(createOp("quit"));        assertFalse(stellarShell.getConsole().isRunning());}
public void metron_f9271_0() throws Exception
{    StellarShell.main(new String[0]);        assertTrue(stdoutWithNewlines().contains(StellarShell.WELCOME));}
public void metron_f9272_0() throws Exception
{        final String buffer = "TO_";        int cursor = buffer.length();        AeshContext context = new DefaultAeshContext();    CompleteOperation op = new CompleteOperation(context, buffer, cursor);    stellarShell.complete(op);        List<String> candidates = op.getFormattedCompletionCandidates();    assertTrue(candidates.size() > 0);        for (String candidate : candidates) {        String completion = buffer + candidate;                assertEquals("(", completion.substring(completion.length() - 1));                String function = completion.substring(0, completion.length() - 1);        Iterable<String> allFunctions = stellarShell.getExecutor().getFunctionResolver().getFunctions();        String definedFunction = Iterables.find(allFunctions, (fn) -> fn.equals(function));        assertEquals(function, definedFunction);    }}
public void metron_f9273_0()
{    completer = new DefaultStellarAutoCompleter();}
public void metron_f9274_0()
{        completer.addCandidateFunction("FREUD");    completer.addCandidateFunction("FRIEND");    completer.addCandidateFunction("FOE");        Iterable<String> result = completer.autoComplete("FR");        List<String> completes = Lists.newArrayList(result);    assertEquals(2, completes.size());        assertThat(completes, hasItem("FREUD("));    assertThat(completes, hasItem("FRIEND("));}
public void metron_f9275_0()
{        completer.addCandidateFunction("FREUD");    completer.addCandidateFunction("FRIEND");    completer.addCandidateFunction("FOE");        Iterable<String> result = completer.autoComplete("G");        List<String> completes = Lists.newArrayList(result);    assertEquals(0, completes.size());}
public void metron_f9276_0()
{        completer.addCandidateVariable("very");    completer.addCandidateVariable("vast");    completer.addCandidateVariable("vat");        Iterable<String> result = completer.autoComplete("va");        List<String> completes = Lists.newArrayList(result);    assertEquals(2, completes.size());    assertThat(completes, hasItem("vast"));    assertThat(completes, hasItem("vat"));}
public void metron_f9277_0()
{        completer.addCandidateVariable("very");    completer.addCandidateVariable("vast");    completer.addCandidateVariable("vat");        Iterable<String> result = completer.autoComplete("x");        List<String> completes = Lists.newArrayList(result);    assertEquals(0, completes.size());}
public void metron_f9278_0()
{        completer.addCandidateFunction("FREUD");    completer.addCandidateFunction("FRIEND");    completer.addCandidateFunction("FOE");        Iterable<String> result = completer.autoComplete("?FR");        List<String> completes = Lists.newArrayList(result);    assertEquals(2, completes.size());        assertThat(completes, hasItem("?FREUD"));    assertThat(completes, hasItem("?FRIEND"));}
public void metron_f9279_0()
{        completer.addCandidateFunction("FREUD");    completer.addCandidateFunction("FRIEND");    completer.addCandidateFunction("FOE");        Iterable<String> result = completer.autoComplete("?G");        List<String> completes = Lists.newArrayList(result);    assertEquals(0, completes.size());}
public void metron_f9280_0()
{        completer.addCandidateFunction("%vars");    completer.addCandidateFunction("%vast");    completer.addCandidateFunction("%verbotten");        Iterable<String> result = completer.autoComplete("%va");        List<String> completes = Lists.newArrayList(result);    assertEquals(2, completes.size());        assertThat(completes, hasItem("%vars"));    assertThat(completes, hasItem("%vast"));}
public void metron_f9281_0()
{        completer.addCandidateFunction("%vars");    completer.addCandidateFunction("%vast");    completer.addCandidateFunction("%verbotten");        Iterable<String> result = completer.autoComplete("%xy");        List<String> completes = Lists.newArrayList(result);    assertEquals(0, completes.size());}
public void metron_f9282_0() throws Exception
{    Properties props = new Properties();    executor = new DefaultStellarShellExecutor(props, Optional.empty());    executor.init();}
public void metron_f9283_0()
{        {        StellarResult result = executor.execute("x := 2 + 2");        assertTrue(result.isSuccess());        assertTrue(result.getValue().isPresent());        assertEquals(4, result.getValue().get());        assertEquals(4, executor.getVariables().get("x"));    }        {        StellarResult result = executor.execute("y := x + 2");        assertTrue(result.isSuccess());        assertTrue(result.getValue().isPresent());        assertEquals(6, result.getValue().get());        assertEquals(6, executor.getVariables().get("y"));    }        {        StellarResult result = executor.execute("z := x + y");        assertTrue(result.isSuccess());        assertTrue(result.getValue().isPresent());        assertEquals(10, result.getValue().get());        assertEquals(10, executor.getVariables().get("z"));    }}
public void metron_f9284_0()
{    List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);        StellarResult result = executor.execute("x := [1,2,3,4,5]");        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(expected, result.getValue().get());        List<Integer> variable = (List<Integer>) executor.getVariables().get("x");    assertEquals(expected, variable);}
public void metron_f9285_0()
{    Map<String, Integer> expected = ImmutableMap.<String, Integer>builder().put("a", 10).put("b", 20).build();        StellarResult result = executor.execute("x := {'a':10, 'b':20}");        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(expected, result.getValue().get());        Map<String, Integer> variable = (Map<String, Integer>) executor.getVariables().get("x");    assertEquals(expected, variable);}
public void metron_f9286_0()
{    StellarResult result = executor.execute("   x   :=    2 +      2      ");    assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(4, result.getValue().get());    assertEquals(4, executor.getVariables().get("x"));}
public void metron_f9287_0()
{    StellarResult result = executor.execute("x := 2 + ");    assertTrue(result.isError());    assertTrue(result.getException().isPresent());}
public void metron_f9288_0()
{    StellarResult result = executor.execute("2 + 2");    assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(4, result.getValue().get());}
public void metron_f9289_0()
{    StellarResult result = executor.execute("    2    +    2");    assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(4, result.getValue().get());}
public void metron_f9290_0()
{    StellarResult result = executor.execute("2 + ");    assertTrue(result.isError());    assertTrue(result.getException().isPresent());}
public void metron_f9291_0()
{        executor.execute("x := 2 + 2");        StellarResult result = executor.execute("%vars");    assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertNotNull(result.getValue().get());}
public void metron_f9292_0()
{        executor.execute("%define x := 2");    assertFalse(executor.getVariables().containsKey("x"));        assertEquals(2, executor.getGlobalConfig().get("x"));}
public void metron_f9293_0()
{    StellarResult result = executor.execute("%invalid");    assertTrue(result.isError());    assertTrue(result.getException().isPresent());}
public void metron_f9294_0()
{        StellarResult result = executor.execute("?TO_STRING");    assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertNotNull(result.getValue().get());}
public void metron_f9295_0()
{    StellarResult result = executor.execute("?INVALID");    assertTrue(result.isError());    assertTrue(result.getException().isPresent());}
public void metron_f9296_0()
{    StellarResult result = executor.execute("quit");    assertTrue(result.isTerminate());}
public void metron_f9297_0()
{    {                executor.assign("x", 10, Optional.empty());    }    {        StellarResult result = executor.execute("x + 2");        assertTrue(result.isSuccess());        assertTrue(result.getValue().isPresent());        assertEquals(12, result.getValue().get());    }}
public void metron_f9298_0()
{    notified = false;    executor.addVariableListener((var, value) -> {        assertEquals("x", var);        assertEquals(4, value.getResult());        notified = true;    });    executor.execute("x := 2 + 2");    assertTrue(notified);}
public void metron_f9299_0() throws Exception
{        notified = false;    Properties props = new Properties();    DefaultStellarShellExecutor executor = new DefaultStellarShellExecutor(props, Optional.empty());        notified = false;    executor.addSpecialListener((magic) -> {        assertNotNull(magic);        assertNotNull(magic.getCommand());        notified = true;    });        executor.init();    assertTrue(notified);}
public void metron_f9300_0() throws Exception
{        notified = false;    Properties props = new Properties();    DefaultStellarShellExecutor executor = new DefaultStellarShellExecutor(props, Optional.empty());        notified = false;    executor.addFunctionListener((fn) -> {        assertNotNull(fn);        assertNotNull(fn.getName());        assertNotNull(fn.getFunction());        notified = true;    });        executor.init();    assertTrue(notified);}
public void metron_f9301_0()
{    StellarResult result = executor.execute("");    assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals("", result.getValue().get());}
public void metron_f9302_0()
{    StellarResult result = executor.execute("# this is a comment");    assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals("", result.getValue().get());}
public void metron_f9303_0()
{    assertNotNull(executor.getGlobalConfig());    assertEquals(0, executor.getGlobalConfig().size());}
public void metron_f9304_0() throws Exception
{    command = new AssignmentCommand();        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(props, Optional.empty());    executor.init();}
public void metron_f9305_0()
{    assertEquals(":=", command.getCommand());}
public void metron_f9306_0()
{    List<String> inputs = Arrays.asList("x := 2 + 2", "   x      :=      2     +  2   ", "  x    :=    2", " x := ");    for (String in : inputs) {        assertTrue("failed: " + in, command.getMatcher().apply(in));    }}
public void metron_f9307_0()
{    List<String> inputs = Arrays.asList("2+2", " %define x := 2", "x");    for (String in : inputs) {        assertFalse("failed: " + in, command.getMatcher().apply(in));    }}
public void metron_f9308_0()
{    StellarResult result = command.execute("x := 2 + 2", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(4, result.getValue().get());        assertEquals(4, executor.getState().get("x").getResult());}
public void metron_f9309_0()
{        assertTrue(command.execute("x := 2 + 2", executor).isSuccess());    assertTrue(command.execute("y := 2 + x", executor).isSuccess());    assertTrue(command.execute("z := x + y", executor).isSuccess());        assertEquals(4, executor.getState().get("x").getResult());    assertEquals(6, executor.getState().get("y").getResult());    assertEquals(10, executor.getState().get("z").getResult());}
public void metron_f9310_0()
{        assertTrue(command.execute("x := 2 + 2", executor).isSuccess());    assertTrue(command.execute("x := 5 + 5", executor).isSuccess());        assertEquals(10, executor.getState().get("x").getResult());}
public void metron_f9311_0()
{        StellarResult result = command.execute("x := z", executor);        assertTrue(result.isSuccess());    assertTrue(result.isValueNull());    assertFalse(result.getValue().isPresent());        assertNull(executor.getState().get("x").getResult());}
public void metron_f9312_0()
{    StellarResult result = command.execute("x := 2 + ", executor);        assertTrue(result.isError());    assertTrue(result.getException().isPresent());        assertFalse(executor.getState().containsKey("x"));}
public void metron_f9313_0()
{    String stmt = "0/0";    StellarResult result = command.execute("x := " + stmt, executor);        assertTrue(result.isError());    assertTrue(result.getException().isPresent());    assertEquals(ParseException.class, result.getException().get().getClass());    assertTrue(result.getException().get().getMessage().contains(stmt));}
public void metron_f9314_0()
{    StellarResult result = command.execute("x := NULL", executor);        assertTrue(result.isSuccess());    assertTrue(result.isValueNull());        assertNull(executor.getState().get("x").getResult());}
public void metron_f9315_0()
{    StellarResult result = command.execute("x := ", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        assertEquals("", executor.getState().get("x").getResult());}
public void metron_f9316_0()
{        executor.assign("x", 10, Optional.empty());        StellarResult result = command.execute("y := x + 2", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(12, result.getValue().get());        assertEquals(10, executor.getState().get("x").getResult());    assertEquals(12, executor.getState().get("y").getResult());}
public void metron_f9317_0()
{    StellarResult result = command.execute("        x   :=    2 +      2", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals(4, result.getValue().get());        assertEquals(4, executor.getState().get("x").getResult());}
public void metron_f9318_0() throws Exception
{        magic = new Comment();        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(props, Optional.empty());    executor.init();}
public void metron_f9319_0()
{    assertEquals("#", magic.getCommand());}
public void metron_f9320_0()
{    List<String> inputs = Arrays.asList("#comment", "   #   comment   ", "      #comment");    for (String in : inputs) {        assertTrue("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9321_0()
{    List<String> inputs = Arrays.asList("foo", "  define ", "bar");    for (String in : inputs) {        assertFalse("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9322_0()
{    StellarResult result = magic.execute("#  this is a comment ", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    assertEquals("", result.getValue().get());}
public void metron_f9323_0() throws Exception
{        command = new DocCommand();        SimpleFunctionResolver functionResolver = new SimpleFunctionResolver().withClass(StringFunctions.ToString.class).withClass(StringFunctions.ToLower.class).withClass(StringFunctions.ToUpper.class);        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(functionResolver, props, Optional.empty());    executor.init();}
public void metron_f9324_0()
{    StellarResult result = command.execute("?TO_STRING", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        assertTrue(result.getValue().toString().length() > 0);}
public void metron_f9325_0()
{    StellarResult result = command.execute("?INVALID", executor);        assertTrue(result.isError());    assertTrue(result.getException().isPresent());}
public void metron_f9326_0()
{    StellarResult result = command.execute("?", executor);        assertTrue(result.isError());    assertTrue(result.getException().isPresent());}
public void metron_f9327_0() throws Exception
{        magic = new MagicDefineGlobal();        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(props, Optional.empty());    executor.init();}
public void metron_f9328_0()
{    assertEquals("%define", magic.getCommand());}
public void metron_f9329_0()
{    List<String> inputs = Arrays.asList("%define", "   %define   ", "%define x := 2", "    %define   x := 2 ");    for (String in : inputs) {        assertTrue("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9330_0()
{    List<String> inputs = Arrays.asList("foo", "  define ", "bar");    for (String in : inputs) {        assertFalse("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9331_0()
{    final int expected = 4;    {        StellarResult result = magic.execute("%define global := 2 + 2", executor);                assertTrue(result.isSuccess());        assertTrue(result.getValue().isPresent());        assertEquals(expected, result.getValue().get());                assertTrue(executor.getGlobalConfig().containsKey("global"));        assertEquals(expected, executor.getGlobalConfig().get("global"));    }        {                StellarResult result = executor.execute("%globals");                assertTrue(result.isSuccess());        assertTrue(result.getValue().isPresent());        String out = ConversionUtils.convert(result.getValue().get(), String.class);        assertEquals("{global=4}", out);    }}
public void metron_f9332_0()
{    StellarResult result = magic.execute("%define 2 + 2", executor);        assertTrue(result.isError());    assertFalse(result.getValue().isPresent());    assertTrue(result.getException().isPresent());        assertEquals(0, executor.getGlobalConfig().size());}
public void metron_f9333_0()
{    StellarResult result = magic.execute("%define", executor);        assertTrue(result.isError());    assertFalse(result.getValue().isPresent());    assertTrue(result.getException().isPresent());        assertEquals(0, executor.getGlobalConfig().size());}
public void metron_f9334_0() throws Exception
{        magic = new MagicListFunctions();        SimpleFunctionResolver functionResolver = new SimpleFunctionResolver().withClass(StringFunctions.ToString.class).withClass(StringFunctions.ToLower.class).withClass(StringFunctions.ToUpper.class);        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(functionResolver, props, Optional.empty());    executor.init();}
public void metron_f9335_0()
{    assertEquals("%functions", magic.getCommand());}
public void metron_f9336_0()
{    List<String> inputs = Arrays.asList("%functions", "   %functions   ", "%functions FOO", "    %functions    FOO ");    for (String in : inputs) {        assertTrue("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9337_0()
{    List<String> inputs = Arrays.asList("foo", "  functions ", "bar", "%define");    for (String in : inputs) {        assertFalse("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9338_0()
{    StellarResult result = magic.execute("%functions", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        String value = ConversionUtils.convert(result.getValue().get(), String.class);    String[] functions = value.split(", ");    assertEquals(3, functions.length);}
public void metron_f9339_0()
{    StellarResult result = magic.execute("%functions UPPER", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        String value = ConversionUtils.convert(result.getValue().get(), String.class);    String[] functions = value.split(", ");    assertEquals(1, functions.length);    assertEquals("TO_UPPER", functions[0]);}
public void metron_f9340_0()
{    StellarResult result = magic.execute("%functions NOMATCH", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        String value = ConversionUtils.convert(result.getValue().get(), String.class);    String[] functions = value.trim().split(", ");    assertEquals(1, functions.length);    assertEquals("", functions[0]);}
public void metron_f9341_0() throws Exception
{        magic = new MagicListGlobals();        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(props, Optional.empty());    executor.init();}
public void metron_f9342_0()
{    assertEquals("%globals", magic.getCommand());}
public void metron_f9343_0()
{    List<String> inputs = Arrays.asList("%globals", "   %globals   ", "%globals   FOO", "    %globals    FOO ");    for (String in : inputs) {        assertTrue("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9344_0()
{    List<String> inputs = Arrays.asList("foo", "  globals ", "bar", "%define");    for (String in : inputs) {        assertFalse("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9345_0()
{        executor.getGlobalConfig().put("x", 2);        StellarResult result = executor.execute("%globals");        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    String out = ConversionUtils.convert(result.getValue().get(), String.class);    assertEquals("{x=2}", out);}
public void metron_f9346_0()
{        StellarResult result = executor.execute("%globals");        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());    String out = ConversionUtils.convert(result.getValue().get(), String.class);    assertEquals("{}", out);}
public void metron_f9347_0() throws Exception
{        magic = new MagicListVariables();        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(props, Optional.empty());    executor.init();}
public void metron_f9348_0()
{    assertEquals("%vars", magic.getCommand());}
public void metron_f9349_0()
{    List<String> inputs = Arrays.asList("%vars", "   %vars   ", "%vars   FOO", "    %vars    FOO ");    for (String in : inputs) {        assertTrue("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9350_0()
{    List<String> inputs = Arrays.asList("foo", "  vars ", "bar", "%define");    for (String in : inputs) {        assertFalse("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9351_0()
{        executor.execute("x := 2 + 2");    StellarResult result = executor.execute("%vars");        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        String vars = ConversionUtils.convert(result.getValue().get(), String.class);    assertEquals("x = 4 via `2 + 2`", vars);}
public void metron_f9352_0()
{        StellarResult result = executor.execute("%vars");        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        String vars = ConversionUtils.convert(result.getValue().get(), String.class);    assertEquals("", vars);}
public void metron_f9353_0() throws Exception
{        magic = new MagicUndefineGlobal();        Properties props = new Properties();    executor = new DefaultStellarShellExecutor(props, Optional.empty());    executor.init();}
public void metron_f9354_0()
{    assertEquals("%undefine", magic.getCommand());}
public void metron_f9355_0()
{    List<String> inputs = Arrays.asList("%undefine", "   %undefine   ", "%undefine   FOO", "    %undefine    FOO ");    for (String in : inputs) {        assertTrue("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9356_0()
{    List<String> inputs = Arrays.asList("foo", "  undefine ", "bar", "%define");    for (String in : inputs) {        assertFalse("failed: " + in, magic.getMatcher().apply(in));    }}
public void metron_f9357_0()
{        executor.getGlobalConfig().put("global", 22);    assertEquals(1, executor.getGlobalConfig().size());        StellarResult result = magic.execute("%undefine global", executor);        assertTrue(result.isSuccess());    assertTrue(result.getValue().isPresent());        assertEquals(0, executor.getGlobalConfig().size());}
public void metron_f9358_0()
{        executor.getGlobalConfig().put("global", 22);    assertEquals(1, executor.getGlobalConfig().size());        StellarResult result = magic.execute("%undefine", executor);        assertTrue(result.isError());    assertTrue(result.getException().isPresent());        assertEquals(1, executor.getGlobalConfig().size());}
public void metron_f9359_0()
{    final int expected = 2;        StellarResult result = StellarResult.success(expected);    assertNotNull(result);        assertTrue(result.getValue().isPresent());    assertEquals(expected, result.getValue().get());        assertFalse(result.getException().isPresent());        assertEquals(StellarResult.Status.SUCCESS, result.getStatus());    assertTrue(result.isSuccess());    assertFalse(result.isError());    assertFalse(result.isTerminate());}
public void metron_f9360_0()
{    final String expected = "my error message";        StellarResult result = StellarResult.error(expected);    assertNotNull(result);        assertFalse(result.getValue().isPresent());        assertTrue(result.getException().isPresent());    assertEquals(expected, result.getException().get().getMessage());        assertEquals(StellarResult.Status.ERROR, result.getStatus());    assertFalse(result.isSuccess());    assertTrue(result.isError());    assertFalse(result.isTerminate());}
public void metron_f9361_0()
{        StellarResult result = StellarResult.terminate();    assertNotNull(result);        assertTrue(result.getValue().isPresent());        assertFalse(result.getException().isPresent());        assertEquals(StellarResult.Status.TERMINATE, result.getStatus());    assertFalse(result.isSuccess());    assertFalse(result.isError());    assertTrue(result.isTerminate());}
public void metron_f9362_0()
{        StellarResult result = StellarResult.noop();    assertNotNull(result);        assertTrue(result.getValue().isPresent());        assertFalse(result.getException().isPresent());        assertEquals(StellarResult.Status.SUCCESS, result.getStatus());    assertTrue(result.isSuccess());    assertFalse(result.isError());    assertFalse(result.isTerminate());}
public void metron_f9363_0()
{    final Object expected = null;        StellarResult result = StellarResult.success(expected);    assertNotNull(result);        assertTrue(result.isValueNull());        assertFalse(result.getException().isPresent());        assertEquals(StellarResult.Status.SUCCESS, result.getStatus());    assertTrue(result.isSuccess());    assertFalse(result.isError());    assertFalse(result.isTerminate());}
public void metron_f9364_0()
{    assertFalse(StellarResult.error(new Exception()).isValueNull());    assertFalse(StellarResult.error("error msg").isValueNull());    assertFalse(StellarResult.noop().isValueNull());    assertFalse(StellarResult.terminate().isValueNull());}
public void metron_f9365_0() throws Exception
{    final long timestamp = 1452013350000L;    String query = "TO_EPOCH_TIMESTAMP('2016-01-05 17:02:30', 'yyyy-MM-dd HH:mm:ss', 'UTC') + 2";    assertEquals(timestamp + 2, run(query, new HashMap<>()));}
public void metron_f9366_0() throws Exception
{    String query = "1 + 2";    assertEquals(3, run(query, new HashMap<>()));}
public void metron_f9367_0() throws Exception
{    String query = "1.0 + 2.0";    assertEquals(3.0, run(query, new HashMap<>()));}
public void metron_f9368_0() throws Exception
{    String query = "2.1 + 1";    assertEquals(3.1, run(query, new HashMap<>()));}
public void metron_f9369_0() throws Exception
{    String query = "1 + 2.1";    assertEquals(3.1, run(query, new HashMap<>()));}
public void metron_f9370_0()
{    assertEquals(3, run("1 + 2", new HashMap<>()));    assertEquals(3.2, run("1.2 + 2", new HashMap<>()));    assertEquals(1.2e-3 + 2, run("1.2e-3 + 2", new HashMap<>()));    assertEquals(1.2f + 3.7, run("1.2f + 3.7", new HashMap<>()));    assertEquals(12L * (1.2f + 7), run("12L*(1.2f + 7)", new HashMap<>()));    assertEquals(12.2f * (1.2f + 7L), run("TO_FLOAT(12.2) * (1.2f + 7L)", new HashMap<>()));}
public void metron_f9371_0()
{    {        String query = "TO_INTEGER(1 + 2*2 + 3 - 4 - 0.5)";        assertEquals(3, (Integer) run(query, new HashMap<>()), 1e-6);    }    {        String query = "1 + 2*2 + 3 - 4 - 0.5";        assertEquals(3.5, (Double) run(query, new HashMap<>()), 1e-6);    }    {        String query = "2*one*(1 + 2*2 + 3 - 4)";        assertEquals(8, run(query, ImmutableMap.of("one", 1)));    }    {        String query = "2*(1 + 2 + 3 - 4)";        assertEquals(4, (Integer) run(query, ImmutableMap.of("one", 1, "very_nearly_one", 1.000001)), 1e-6);    }    {        String query = "1 + 2 + 3 - 4 - 2";        assertEquals(0, (Integer) run(query, ImmutableMap.of("one", 1, "very_nearly_one", 1.000001)), 1e-6);    }    {        String query = "1 + 2 + 3 + 4";        assertEquals(10, (Integer) run(query, ImmutableMap.of("one", 1, "very_nearly_one", 1.000001)), 1e-6);    }    {        String query = "(one + 2)*3";        assertEquals(9, (Integer) run(query, ImmutableMap.of("one", 1, "very_nearly_one", 1.000001)), 1e-6);    }    {        String query = "TO_INTEGER((one + 2)*3.5)";        assertEquals(10, (Integer) run(query, ImmutableMap.of("one", 1, "very_nearly_one", 1.000001)), 1e-6);    }    {        String query = "1 + 2*3";        assertEquals(7, (Integer) run(query, ImmutableMap.of("one", 1, "very_nearly_one", 1.000001)), 1e-6);    }    {        String query = "TO_LONG(foo)";        Assert.assertNull(run(query, ImmutableMap.of("foo", "not a number")));    }    {        String query = "TO_LONG(foo)";        assertEquals(232321L, run(query, ImmutableMap.of("foo", "00232321")));    }    {        String query = "TO_LONG(foo)";        assertEquals(Long.MAX_VALUE, run(query, ImmutableMap.of("foo", Long.toString(Long.MAX_VALUE))));    }}
public void metron_f9372_0() throws Exception
{    Token<Integer> integer = mock(Token.class);    when(integer.getValue()).thenReturn(1);    Token<Long> lng = mock(Token.class);    when(lng.getValue()).thenReturn(1L);    Token<Double> dbl = mock(Token.class);    when(dbl.getValue()).thenReturn(1.0D);    Token<Float> flt = mock(Token.class);    when(flt.getValue()).thenReturn(1.0F);    Map<Pair<String, String>, Class<? extends Number>> expectedReturnTypeMappings = new HashMap<Pair<String, String>, Class<? extends Number>>() {        {            put(Pair.of("TO_FLOAT(3.0)", "TO_LONG(1)"), Float.class);            put(Pair.of("TO_FLOAT(3)", "3.0"), Double.class);            put(Pair.of("TO_FLOAT(3)", "TO_FLOAT(3)"), Float.class);            put(Pair.of("TO_FLOAT(3)", "3"), Float.class);            put(Pair.of("TO_LONG(1)", "TO_LONG(1)"), Long.class);            put(Pair.of("TO_LONG(1)", "3.0"), Double.class);            put(Pair.of("TO_LONG(1)", "TO_FLOAT(3)"), Float.class);            put(Pair.of("TO_LONG(1)", "3"), Long.class);            put(Pair.of("3.0", "TO_LONG(1)"), Double.class);            put(Pair.of("3.0", "3.0"), Double.class);            put(Pair.of("3.0", "TO_FLOAT(3)"), Double.class);            put(Pair.of("3.0", "3"), Double.class);            put(Pair.of("3", "TO_LONG(1)"), Long.class);            put(Pair.of("3", "3.0"), Double.class);            put(Pair.of("3", "TO_FLOAT(3)"), Float.class);            put(Pair.of("3", "3"), Integer.class);        }    };    expectedReturnTypeMappings.forEach((pair, expectedClass) -> {        assertTrue(run(pair.getLeft() + " * " + pair.getRight(), ImmutableMap.of()).getClass() == expectedClass);        assertTrue(run(pair.getLeft() + " + " + pair.getRight(), ImmutableMap.of()).getClass() == expectedClass);        assertTrue(run(pair.getLeft() + " - " + pair.getRight(), ImmutableMap.of()).getClass() == expectedClass);        assertTrue(run(pair.getLeft() + " / " + pair.getRight(), ImmutableMap.of()).getClass() == expectedClass);    });}
public void metron_f9373_0() throws Exception
{    Object run = run(".0f * 1", ImmutableMap.of());    assertEquals(.0f * 1, run);    assertEquals(Float.class, run.getClass());    Object run1 = run("0.f / 1F", ImmutableMap.of());    assertEquals(0.f / 1F, run1);    assertEquals(Float.class, run1.getClass());    Object run2 = run(".0F + 1.0f", ImmutableMap.of());    assertEquals(.0F + 1.0f, run2);    assertEquals(Float.class, run2.getClass());    Object run3 = run("0.0f - 0.1f", ImmutableMap.of());    assertEquals(0.0f - 0.1f, run3);    assertEquals(Float.class, run2.getClass());}
public void metron_f9374_0() throws Exception
{    assertEquals(0L * 1L, run("0L * 1L", ImmutableMap.of()));    assertEquals(0l / 1L, run("0l / 1L", ImmutableMap.of()));    assertEquals(1L - 1l, run("1L - 1l", ImmutableMap.of()));    assertEquals(2147483648L + 1L, run("2147483648L + 1L", ImmutableMap.of()));}
public void metron_f9375_0() throws Exception
{    assertEquals((((((1L) + .5d)))) * 6.f, run("(((((1L) + .5d)))) * 6.f", ImmutableMap.of()));    assertEquals((((((1L) + .5d)))) * 6.f / 0.f, run("(((((1L) + .5d)))) * 6.f / 0.f", ImmutableMap.of()));    assertEquals(Double.class, run("(((((1L) + .5d)))) * 6.f / 0.f", ImmutableMap.of()).getClass());}
public void metron_f9376_0() throws Exception
{    {        assertEquals(Float.class, run("6.f", ImmutableMap.of()).getClass());        assertEquals(Float.class, run(".0f", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("6.0F", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("6f", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("6e-6f", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("6e+6f", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("6e6f", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("TO_FLOAT(1231)", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("TO_FLOAT(12.31)", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("TO_FLOAT(12.31f)", ImmutableMap.of()).getClass());        assertEquals(Float.class, run("TO_FLOAT(12L)", ImmutableMap.of()).getClass());    }    {        assertEquals(Double.class, run("6.d", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("6.D", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("6.0d", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("6D", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("6e5D", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("6e-5D", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("6e+5D", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("TO_DOUBLE(1231)", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("TO_DOUBLE(12.31)", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("TO_DOUBLE(12.31f)", ImmutableMap.of()).getClass());        assertEquals(Double.class, run("TO_DOUBLE(12L)", ImmutableMap.of()).getClass());    }    {        assertEquals(Integer.class, run("6", ImmutableMap.of()).getClass());        assertEquals(Integer.class, run("60000000", ImmutableMap.of()).getClass());        assertEquals(Integer.class, run("-0", ImmutableMap.of()).getClass());        assertEquals(Integer.class, run("-60000000", ImmutableMap.of()).getClass());        assertEquals(Integer.class, run("TO_INTEGER(1231)", ImmutableMap.of()).getClass());        assertEquals(Integer.class, run("TO_INTEGER(12.31)", ImmutableMap.of()).getClass());        assertEquals(Integer.class, run("TO_INTEGER(12.31f)", ImmutableMap.of()).getClass());        assertEquals(Integer.class, run("TO_INTEGER(12L)", ImmutableMap.of()).getClass());    }    {        assertEquals(Long.class, run("12345678910l", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("0l", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("-0l", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("-60000000L", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("-60000000L", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("TO_LONG(1231)", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("TO_LONG(12.31)", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("TO_LONG(12.31f)", ImmutableMap.of()).getClass());        assertEquals(Long.class, run("TO_LONG(12L)", ImmutableMap.of()).getClass());    }}
public void metron_f9377_0() throws Exception
{    exception.expect(ParseException.class);    run("000000", ImmutableMap.of());}
public void metron_f9378_0() throws Exception
{    exception.expect(ParseException.class);    run("000000l", ImmutableMap.of());}
public void metron_f9379_0() throws Exception
{    exception.expect(ParseException.class);    run("000000d", ImmutableMap.of());}
public void metron_f9380_0() throws Exception
{    exception.expect(ParseException.class);    run("000000f", ImmutableMap.of());}
public void metron_f9381_0() throws Exception
{    exception.expect(ParseException.class);    run("--000000f", ImmutableMap.of());}
public void metron_f9382_0() throws Exception
{    exception.expect(ParseException.class);    run("--000000D", ImmutableMap.of());}
public void metron_f9383_0() throws Exception
{    exception.expect(ParseException.class);    run("--000000L", ImmutableMap.of());}
public void metron_f9384_0() throws Exception
{    run("0/0", ImmutableMap.of());}
public void metron_f9385_0() throws Exception
{    run("0L/0L", ImmutableMap.of());}
public void metron_f9386_0() throws Exception
{    assertEquals(0F / 0F, run("0F/0F", ImmutableMap.of()));    assertEquals(0D / 0D, run("0D/0D", ImmutableMap.of()));    assertEquals(0D / 0F, run("0D/0F", ImmutableMap.of()));    assertEquals(0F / 0D, run("0F/0D", ImmutableMap.of()));    assertEquals(0F / 0, run("0F/0", ImmutableMap.of()));    assertEquals(0D / 0, run("0D/0", ImmutableMap.of()));    assertEquals(0 / 0D, run("0/0D", ImmutableMap.of()));    assertEquals(0 / 0F, run("0/0F", ImmutableMap.of()));}
public void metron_f9387_0()
{    for (String statement : ImmutableList.of("foo := bar + grok", "foo   := bar + grok", "foo := bar + grok   ")) {        StellarAssignment assignment = StellarAssignment.from(statement);        Assert.assertEquals("foo", assignment.getKey());        Assert.assertEquals("foo", assignment.getVariable());        Assert.assertEquals("bar + grok", assignment.getStatement());        Assert.assertEquals("bar + grok", assignment.getValue());    }}
public void metron_f9388_0()
{    for (String statement : ImmutableList.of("bar + grok", "  bar + grok", "bar + grok   ")) {        StellarAssignment assignment = StellarAssignment.from(statement);        Assert.assertNull(assignment.getKey());        Assert.assertNull(assignment.getVariable());        Assert.assertEquals("bar + grok", assignment.getStatement());        Assert.assertEquals("bar + grok", assignment.getValue());    }}
public void metron_f9389_0()
{    StellarAssignment assignment = StellarAssignment.from("foo := bar");    assignment.setValue("myval");}
public void metron_f9390_0() throws Exception
{    assertEquals(1 < 2, run("1 < 2", ImmutableMap.of()));    assertEquals(1f < 2, run("1f < 2", ImmutableMap.of()));    assertEquals(1f < 2d, run("1f < 2d", ImmutableMap.of()));    assertEquals(1f < 2e-4d, run("1f < 2e-4d", ImmutableMap.of()));    assertEquals(1L < 2e-4d, run("1L < 2e-4d", ImmutableMap.of()));    assertEquals(1 < 2e-4d, run("1 < 2e-4d", ImmutableMap.of()));    assertEquals(1 < 2L, run("1 < 2L", ImmutableMap.of()));    assertEquals(1.0f < 2.0f, run("1.0f < 2.0f", ImmutableMap.of()));    assertEquals(1L < 3.0f, run("1L < 3.0f", ImmutableMap.of()));    assertEquals(1 < 3.0f, run("1 < 3.0f", ImmutableMap.of()));    assertEquals(1.0 < 3.0f, run("1.0 < 3.0f", ImmutableMap.of()));    boolean thrown = false;    try {        run("foo < 3.0f", ImmutableMap.of());    } catch (ParseException pe) {        thrown = true;    }    assertTrue(thrown);    thrown = false;    try {        run("foo < foo", ImmutableMap.of());    } catch (ParseException pe) {        thrown = true;    }    assertTrue(thrown);    assertEquals(1L < 3.0f ? true : false, run("if 1L < 3.0f then true else false", ImmutableMap.of()));}
public void metron_f9391_0() throws Exception
{    assertEquals(1f >= 2, run("TO_FLOAT(1) >= 2", ImmutableMap.of()));    assertEquals(1f <= 2, run("TO_FLOAT(1) <= TO_FLOAT(2)", ImmutableMap.of()));    assertEquals(1f == 2, run("TO_FLOAT(1) == TO_LONG(2)", ImmutableMap.of()));    assertEquals(12.31f == 10.2f, run("TO_FLOAT(12.31) < 10.2f", ImmutableMap.of()));}
public void metron_f9392_0() throws Exception
{    final Map<String, String> variableMap = new HashMap<String, String>() {        {            put("foo", "casey");            put("empty", "");            put("spaced", "metron is great");            put("foo.bar", "casey");        }    };    assertTrue(runPredicate("'casey' == foo.bar", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("'casey' == foo", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("'casey' != foo", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("'stella' == 'stella'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("'stella' == foo", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("foo== foo", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("empty== ''", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("spaced == 'metron is great'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate(null, new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate(" ", (new DefaultVariableResolver(variableMap::get, variableMap::containsKey))));}
public void metron_f9393_0() throws Exception
{    Map<String, String> variableMap = new HashMap<>();    assertFalse(runPredicate("1 == '1'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("'1' == 1", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9394_0() throws Exception
{    Map<String, String> variableMap = new HashMap<>();    assertFalse(runPredicate("null == '1'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("\"1\" == null", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("null == null", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9395_0() throws Exception
{    Map<String, String> variableMap = new HashMap<>();    assertTrue(runPredicate("\"1\" == '1'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("'1' == \"1\"", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("'1' == \"1\"", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9396_0() throws Exception
{    Map<String, String> variableMap = new HashMap<>();    assertFalse(runPredicate("55 == '7'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("97 == 'a'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9397_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<String, Object>() {        {            put("foo", "casey");            put("bar", "bar.casey.grok");            put("ip", "192.168.0.1");            put("num", 7);            put("num2", 8.5);            put("num3", 7);            put("num4", "8.5");            put("empty", "");            put("spaced", "metron is great");        }    };    assertTrue(runPredicate("num == 7", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("num < num2", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("num < TO_DOUBLE(num2)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("num < TO_DOUBLE(num4)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("num < 100", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("num == num3", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("num == num2", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("num == num2 || true", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("num > num2", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("num == 7 && num > 2", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9398_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<String, Object>() {        {            put("num", -0);        }    };    Arrays.asList("!=", "==").forEach(op -> {        assertEquals("==".equals(op), runPredicate("num " + op + " 0", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("==".equals(op), runPredicate("0 " + op + " -0", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("==".equals(op), runPredicate("0 " + op + " -0d", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("==".equals(op), runPredicate("-0 " + op + " 0", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("==".equals(op), runPredicate("-0F " + op + " 0D", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("==".equals(op), runPredicate("-0.F " + op + " 0", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("==".equals(op), runPredicate("-0.F " + op + " 0F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("==".equals(op), runPredicate("-0.D " + op + " 0D", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    });}
public void metron_f9399_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    Arrays.asList("!=", "==").forEach(op -> {        assertEquals("!=".equals(op), runPredicate("(0f/0f) " + op + " (0f/0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(-0f/0f) " + op + " (0f/0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(-0f/-0f) " + op + " (0f/0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(-0f/-0f) " + op + " (-0f/0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(-0f/-0f) " + op + " (-0f/-0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(0f/-0f) " + op + " (0f/0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(0f/-0f) " + op + " (-0f/0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(0f/-0f) " + op + " (-0f/-0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(0f/0f) " + op + " (-0f/0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(0f/0d) " + op + " (-0f/-0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(0d/-0f) " + op + " (0f/-0f)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(-0f/0f) " + op + " (0f/-0d)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(-0d/-0d) " + op + " (0d/-0d)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals("!=".equals(op), runPredicate("(0d/0d) " + op + " (0d/0d)", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    });}
public void metron_f9400_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<String, Object>() {        {            put("t", true);            put("f", false);        }    };    assertTrue(runPredicate("t != f", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("f != t", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("true != false", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("true != true", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("false != true", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("false != false", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("t == f", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("f == t", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("true == false", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("true == true", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("false == true", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("false == false", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("null == false", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("null == true", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("true == NULL", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("false == NULL", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9401_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    assertFalse(runPredicate("null == false", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("null == true", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("true == NULL", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("false == NULL", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("1 == NULL", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("'null' == NULL", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("'' == NULL", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertFalse(runPredicate("null == ''", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    assertTrue(runPredicate("NULL == null", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9402_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    assertEquals(0.1 + 0.2 == 0.3, runPredicate("0.1 + 0.2 == 0.3", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));}
public void metron_f9403_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    runPredicate("1 < '1'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey));}
public void metron_f9404_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    runPredicate("'1' <= 1", new DefaultVariableResolver(variableMap::get, variableMap::containsKey));}
public void metron_f9405_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    runPredicate("1 > '1'", new DefaultVariableResolver(variableMap::get, variableMap::containsKey));}
public void metron_f9406_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    runPredicate("'1' >= 1", new DefaultVariableResolver(variableMap::get, variableMap::containsKey));}
public void metron_f9407_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    final Integer[] result = { 0 };    Stream.of("<", "<=", ">", ">=").forEach(op -> {        assertFalse(runPredicate("'1' " + op + " null", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    });}
public void metron_f9408_0() throws Exception
{    final Map<String, Object> variableMap = new HashMap<>();    {        assertEquals(1 == 1.00000001, runPredicate("1 == 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 < 1.00000001, runPredicate("1 < 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 <= 1.00000001, runPredicate("1 <= 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 > 1.00000001, runPredicate("1 > 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 >= 1.00000001, runPredicate("1 >= 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    }    {        assertEquals(1 == 1.00000001F, runPredicate("1 == 1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 < 1.00000001F, runPredicate("1 < 1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 <= 1.00000001F, runPredicate("1 <= 1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 > 1.00000001F, runPredicate("1 > 1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1 >= 1.00000001F, runPredicate("1 >= 1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    }    {        assertEquals(1.00000001F == 1.00000001, runPredicate("1.00000001F == 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1.00000001F < 1.00000001, runPredicate("1.00000001F < 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1.00000001F <= 1.00000001, runPredicate("1.00000001F <= 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1.00000001F > 1.00000001, runPredicate("1.00000001F > 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(1.00000001F >= 1.00000001, runPredicate("1.00000001F >= 1.00000001", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    }    {        assertEquals(-1L == -1.00000001F, runPredicate("-1L == -1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(-1L < -1.00000001F, runPredicate("-1L < -1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(-1L <= -1.00000001F, runPredicate("-1L <= -1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(-1L > -1.00000001F, runPredicate("-1L > -1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));        assertEquals(-1L >= -1.00000001F, runPredicate("-1L >= -1.00000001F", new DefaultVariableResolver(variableMap::get, variableMap::containsKey)));    }}
public void metron_f9409_0() throws Exception
{    variableResolver = mock(VariableResolver.class);    functionResolver = mock(FunctionResolver.class);    context = mock(Context.class);    tokenStack = new ArrayDeque<>();    arithmeticEvaluator = mock(ArithmeticEvaluator.class);    numberLiteralEvaluator = mock(NumberLiteralEvaluator.class);    comparisonExpressionWithOperatorEvaluator = mock(ComparisonExpressionWithOperatorEvaluator.class);    expression = new StellarCompiler.Expression(tokenStack);    compiler = new StellarCompiler(expression, arithmeticEvaluator, numberLiteralEvaluator, comparisonExpressionWithOperatorEvaluator);}
public void metron_f9410_0() throws Exception
{    StellarParser.IntLiteralContext ctx = mock(StellarParser.IntLiteralContext.class);    Token result = mock(Token.class);    when(ctx.getText()).thenReturn("1000");    when(numberLiteralEvaluator.evaluate(ctx, null)).thenReturn(result);    compiler.exitIntLiteral(ctx);    verify(numberLiteralEvaluator).evaluate(ctx, null);    Assert.assertEquals(1, tokenStack.size());    Assert.assertEquals(tokenStack.getFirst(), result);    verifyZeroInteractions(variableResolver);    verifyZeroInteractions(functionResolver);    verifyZeroInteractions(context);    verifyZeroInteractions(arithmeticEvaluator);    verifyZeroInteractions(comparisonExpressionWithOperatorEvaluator);}
public void metron_f9411_0() throws Exception
{    StellarParser.DoubleLiteralContext ctx = mock(StellarParser.DoubleLiteralContext.class);    Token result = mock(Token.class);    when(numberLiteralEvaluator.evaluate(ctx, null)).thenReturn(result);    when(ctx.getText()).thenReturn("1000D");    compiler.exitDoubleLiteral(ctx);    verify(numberLiteralEvaluator).evaluate(ctx, null);    Assert.assertEquals(1, tokenStack.size());    Assert.assertEquals(tokenStack.getFirst(), result);    verifyZeroInteractions(variableResolver);    verifyZeroInteractions(functionResolver);    verifyZeroInteractions(context);    verifyZeroInteractions(arithmeticEvaluator);    verifyZeroInteractions(comparisonExpressionWithOperatorEvaluator);}
public void metron_f9412_0() throws Exception
{    StellarParser.FloatLiteralContext ctx = mock(StellarParser.FloatLiteralContext.class);    when(ctx.getText()).thenReturn("1000f");    Token result = mock(Token.class);    when(numberLiteralEvaluator.evaluate(ctx, null)).thenReturn(result);    compiler.exitFloatLiteral(ctx);    verify(numberLiteralEvaluator).evaluate(ctx, null);    Assert.assertEquals(1, tokenStack.size());    Assert.assertEquals(tokenStack.getFirst(), result);    verifyZeroInteractions(variableResolver);    verifyZeroInteractions(functionResolver);    verifyZeroInteractions(context);    verifyZeroInteractions(arithmeticEvaluator);    verifyZeroInteractions(comparisonExpressionWithOperatorEvaluator);}
public void metron_f9413_0() throws Exception
{    StellarParser.LongLiteralContext ctx = mock(StellarParser.LongLiteralContext.class);    when(ctx.getText()).thenReturn("1000l");    Token result = mock(Token.class);    when(numberLiteralEvaluator.evaluate(ctx, null)).thenReturn(result);    compiler.exitLongLiteral(ctx);    verify(numberLiteralEvaluator).evaluate(ctx, null);    Assert.assertEquals(1, tokenStack.size());    Assert.assertEquals(tokenStack.getFirst(), result);    verifyZeroInteractions(variableResolver);    verifyZeroInteractions(functionResolver);    verifyZeroInteractions(context);    verifyZeroInteractions(arithmeticEvaluator);    verifyZeroInteractions(comparisonExpressionWithOperatorEvaluator);}
public void metron_f9414_0() throws Exception
{    StellarParser.ComparisonExpressionWithOperatorContext ctx = mock(StellarParser.ComparisonExpressionWithOperatorContext.class);    StellarParser.ComparisonOpContext mockOp = mock(StellarParser.ComparisonOpContext.class);    when(ctx.comp_operator()).thenReturn(mockOp);    Token result = mock(Token.class);    when(comparisonExpressionWithOperatorEvaluator.evaluate(any(Token.class), any(Token.class), any(StellarParser.ComparisonOpContext.class), any())).thenReturn(result);    compiler.exitComparisonExpressionWithOperator(ctx);    Assert.assertEquals(1, tokenStack.size());    StellarCompiler.DeferredFunction func = (StellarCompiler.DeferredFunction) tokenStack.pop().getValue();    tokenStack.push(new Token<>(1000, Integer.class, null));    tokenStack.push(new Token<>(1500f, Float.class, null));    func.apply(tokenStack, new StellarCompiler.ExpressionState(context, functionResolver, variableResolver));    Assert.assertEquals(1, tokenStack.size());    Assert.assertEquals(tokenStack.getFirst(), result);    verify(comparisonExpressionWithOperatorEvaluator).evaluate(any(Token.class), any(Token.class), eq(mockOp), any());    verifyZeroInteractions(numberLiteralEvaluator);    verifyZeroInteractions(variableResolver);    verifyZeroInteractions(functionResolver);    verifyZeroInteractions(context);    verifyZeroInteractions(arithmeticEvaluator);}
public void metron_f9415_0() throws Exception
{    StellarPredicateProcessor processor = new StellarPredicateProcessor();    try {        processor.validate("enrichedField1 == 'enrichedValue1");        fail("Invalid rule found to be valid - unclosed single quotes.");    } catch (ParseException e) {    }}
public void metron_f9416_0() throws Exception
{    Clock clock = new Clock();    long t1 = clock.currentTimeMillis();    Thread.sleep(50);    long t2 = clock.currentTimeMillis();    Thread.sleep(50);    long t3 = clock.currentTimeMillis();    assertThat("t3 should be greater", t3 > t2, equalTo(true));    assertThat("t2 should be greater", t2 > t1, equalTo(true));}
public void metron_f9417_0() throws Exception
{    Clock clock = Mockito.spy(Clock.class);    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));    Date date = sdf.parse("20160615183527162+0000");    Mockito.when(clock.currentTimeMillis()).thenReturn(date.getTime());    assertThat("time not right", clock.currentTimeFormatted("yyyyMMddHHmmssSSSZ"), equalTo("20160615183527162+0000"));}
public void metron_f9418_0()
{    BloomFilter bloomString = (BloomFilter) run("BLOOM_ADD(BLOOM_INIT(), string)", variables);    BloomFilter bloomDouble = (BloomFilter) run("BLOOM_ADD(BLOOM_INIT(), double)", variables);    BloomFilter bloomInteger = (BloomFilter) run("BLOOM_ADD(BLOOM_INIT(), integer)", variables);    BloomFilter bloomMap = (BloomFilter) run("BLOOM_ADD(BLOOM_INIT(), map)", variables);    BloomFilter merged = (BloomFilter) run("BLOOM_MERGE([stringFilter, doubleFilter, integerFilter, mapFilter])", ImmutableMap.of("stringFilter", bloomString, "doubleFilter", bloomDouble, "integerFilter", bloomInteger, "mapFilter", bloomMap));    Assert.assertNotNull(merged);    for (Object val : variables.values()) {        Assert.assertTrue(merged.mightContain(val));    }}
public void metron_f9419_0()
{    BloomFilter result = (BloomFilter) run("BLOOM_ADD(BLOOM_INIT(), string, double, integer, map)", variables);    for (Object val : variables.values()) {        Assert.assertTrue(result.mightContain(val));    }    Assert.assertTrue(result.mightContain(ImmutableMap.of("key1", "value1", "key2", "value2")));}
public void metron_f9420_0()
{    {        Boolean result = (Boolean) run("BLOOM_EXISTS(BLOOM_ADD(BLOOM_INIT(), string, double, integer, map), 'casey')", variables);        Assert.assertTrue(result);    }    {        Boolean result = (Boolean) run("BLOOM_EXISTS(BLOOM_ADD(BLOOM_INIT(), string, double, integer, map), double)", variables);        Assert.assertTrue(result);    }    {        Boolean result = (Boolean) run("BLOOM_EXISTS(BLOOM_ADD(BLOOM_INIT(), string, double, integer, map), integer)", variables);        Assert.assertTrue(result);    }    {        Boolean result = (Boolean) run("BLOOM_EXISTS(BLOOM_ADD(BLOOM_INIT(), string, double, integer, map), map)", variables);        Assert.assertTrue(result);    }    {        Boolean result = (Boolean) run("BLOOM_EXISTS(BLOOM_ADD(BLOOM_INIT(), string, double, integer, map), 'samantha')", variables);        Assert.assertFalse(result);    }    {        boolean thrown = false;        try {            run("BLOOM_EXISTS(BLOOM_ADD(BLOOM_INIT(), string, double, integer, map), sam)", variables);        } catch (ParseException pe) {            thrown = true;        }        Assert.assertTrue(thrown);    }}
public void metron_f9421_0() throws Exception
{    Map<String, Object> v1 = new HashMap<>();    v1.put("k1", "v1");    Map<String, Object> v2 = new HashMap<>();    v2.put("k2", "v2");    v2.put("k3", null);    Map<String, Object> union = new HashMap<String, Object>() {        {            putAll(v1);            put("k2", "v2");        }    };    ConcatMap c = create(v1, v2);    Assert.assertEquals(c.toString(), union.toString());}
private ConcatMap metron_f9422_0(Map... ms)
{    List<Map> l = new ArrayList<>();    for (Map m : ms) {        l.add(m);    }    return new ConcatMap(l);}
private void metron_f9423_0(ConcatMap c)
{    byte[] serialized = SerDeUtils.toBytes(c);    ConcatMap deserialized = SerDeUtils.fromBytes(serialized, ConcatMap.class);    Assert.assertEquals(deserialized, c);}
public void metron_f9424_0()
{    Map<String, Object> v1 = new HashMap<>();    v1.put("k1", "v1");    Map<String, Object> v2 = new HashMap<>();    v2.put("k2", "v2");    v2.put("k3", null);    {                ConcatMap c = create(v1, v2);        assertKryoserializable(c);    }    {                ConcatMap c = create(v1);        assertKryoserializable(c);    }    {                ConcatMap c = create();        assertKryoserializable(c);    }}
public void metron_f9425_0()
{    Object o = 1;    Assert.assertEquals(Integer.valueOf(1), ConversionUtils.convert(o, Integer.class));    Assert.assertEquals(Integer.valueOf(1), ConversionUtils.convert("1", Integer.class));    Assert.assertNull(ConversionUtils.convert("foo", Integer.class));}
public void metron_f9426_0() throws Exception
{    assertEquals(StringUtils.repeat("00", 16), new DefaultHasher("md5", encoder).getHash(null));    assertEquals(StringUtils.repeat("00", 32), new DefaultHasher("sha-256", encoder).getHash(null));}
public void metron_f9427_0() throws Exception
{    assertNull(new DefaultHasher("md5", encoder, charset).getHash(new Object()));}
public void metron_f9428_0() throws Exception
{    assertEquals("d41d8cd98f00b204e9800998ecf8427e", new DefaultHasher("md5", encoder).getHash(""));}
public void metron_f9429_0() throws Exception
{    final Collection<String> serializable = Collections.emptyList();    assertEquals("ef5e8c8d27af3a953b4674065c99a52a", new DefaultHasher("md5", encoder, charset).getHash(serializable));}
public static void metron_f9430_0() throws Exception
{    tmpDir = UnitTestHelper.createTempDir(new File("target/jsonutilstest"));    configFile = UnitTestHelper.write(new File(tmpDir, "config.json"), config);}
public void metron_f9431_0() throws Exception
{    Map<String, Object> expected = new HashMap<String, Object>() {        {            put("a", "hello");            put("b", "world");        }    };    Map<String, Object> actual = JSONUtils.INSTANCE.load(configFile, JSONUtils.MAP_SUPPLIER);    Assert.assertThat("config not equal", actual, equalTo(expected));}
