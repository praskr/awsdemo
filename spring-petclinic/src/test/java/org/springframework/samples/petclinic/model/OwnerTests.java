/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * JUnit test for the {@link Owner} class.
 *
 * @author Ken Krebs
 */
public class OwnerTests {

    @Test
    @Transactional
    public void testHasPet() {
        Owner owner = new Owner();
        Pet fido = new Pet();
        fido.setName("Fido");
        assertNull(owner.getPet("Fido"));
        assertNull(owner.getPet("fido"));
        owner.addPet(fido);
        assertEquals(fido, owner.getPet("Fido"));
        assertEquals(fido, owner.getPet("fido"));
    }

    @Test
    @Transactional
    public void addPet() {
        Owner owner = new Owner();
        Pet fido = new Pet();
        fido.setName("Fido2");
        owner.addPet(fido);
        assertEquals(fido, owner.getPet("Fido2"));
        assertNull(owner.getPet("Lido"));
    }
    
    @Test
    @Transactional
    public void getPets() {
        Owner owner = new Owner();
        owner.setFirstName("Maria");
        Pet fido1 = new Pet();
        fido1.setName("Fido1");
        owner.addPet(fido1);
        Pet fido2 = new Pet();
        fido2.setName("Fido2");
        owner.addPet(fido2);
        List<Pet> pets = owner.getPets();
        for(Pet p : pets) {
        	assertEquals("Maria", p.getOwner().getFirstName());
        }
    }

    @Test
    @Transactional
    public void addVisit() {
        Owner owner = new Owner();
        Pet fido = new Pet();
        fido.setName("Fido");
        Visit v = new Visit();
        v.setDate(new DateTime());
        v.setDescription("Leg Enjury");
        fido.addVisit(v);
        owner.addPet(fido);
        assertEquals(v.getDescription(), owner.getPet("Fido").getVisits().get(0).getDescription());
    }
}
