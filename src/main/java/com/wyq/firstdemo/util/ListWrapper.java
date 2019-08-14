package com.wyq.firstdemo.util;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ListWrapper<E> {
    @Valid
    private List<E> list;

    public ListWrapper() {
        list = new ArrayList<>();
    }

    public  ListWrapper(List<E> list) {
        this.list = list;
    }

}
