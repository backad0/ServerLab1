package com.serverlabs.serverlab1.services.validator;

import java.util.List;

public interface IValidator <T>{
    List<String> validator(T request);
}
