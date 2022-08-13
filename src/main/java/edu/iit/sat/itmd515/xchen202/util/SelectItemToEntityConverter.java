/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.util;

import edu.iit.sat.itmd515.xchen202.domain.GenericEntity;
import java.util.List;
import java.util.function.Predicate;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Example from Web
 * author XCHEN202 date 03-27-2022 23:49 version V1.0 Lab6 desc edit page choice
 * entity
 * https://stackoverflow.com/questions/4734580/conversion-error-setting-value-for-null-converter-why-do-i-need-a-converter
 * https://code-examples.net/en/q/a5932d
 */
@FacesConverter(value = "SelectItemToEntityConverter")
public class SelectItemToEntityConverter implements Converter {

    /**
     * Get GenericEntity by id
     *
     * @param ctx
     * @param comp
     * @param value
     * @return
     */
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
        Object o = null;
        if (!(value == null || value.isEmpty())) {
            o = this.getSelectedItemAsEntity(comp, value);
        }
        return o;
    }

    /**
     * Get id by GenericEntity
     *
     * @param ctx
     * @param comp
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
        String s = "";
        if (value != null) {
            s = ((GenericEntity) value).getId().toString();
        }
        return s;
    }

    /**
     * Get GenericEntity by id
     *
     * @param comp
     * @param value
     * @return
     */
    private GenericEntity getSelectedItemAsEntity(UIComponent comp, String value) {
        GenericEntity item = null;

        List<GenericEntity> selectItems = null;
        for (UIComponent uic : comp.getChildren()) {
            if (uic instanceof UISelectItems) {
                Long itemId = Long.valueOf(value);
                selectItems = (List<GenericEntity>) ((UISelectItems) uic).getValue();

                if (itemId != null && selectItems != null && !selectItems.isEmpty()) {
                    Predicate<GenericEntity> predicate = i -> i.getId().equals(itemId);
                    item = selectItems.stream().filter(predicate).findFirst().orElse(null);
                }
            }
        }

        return item;
    }
}
