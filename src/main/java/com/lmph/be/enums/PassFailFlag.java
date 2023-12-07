package com.lmph.be.enums;

import lombok.Data;

public enum PassFailFlag {

    Unset (null),
    Failed (false),
    Passed (true);

    PassFailFlag(Boolean l){}
}
