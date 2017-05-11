foo bar = foo();
boolean is_empty = !(bar != null && !bar.empty());
if(is_empty)
    bar.first().compute();
