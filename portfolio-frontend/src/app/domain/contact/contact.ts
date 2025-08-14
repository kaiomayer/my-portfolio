import { Component } from '@angular/core';
import {Hero} from '../../core/layout/hero/hero';
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {GenericInput} from '../../shared/components/generic-input/generic-input';
import {MailFormControl} from '../../shared/models/mailFormControl.model';
import {MatButton} from '@angular/material/button';

@Component({
  selector: 'app-contact',
  imports: [
    Hero,
    FormsModule,
    ReactiveFormsModule,
    GenericInput,
    MatButton
  ],
  templateUrl: './contact.html',
  styleUrl: './contact.scss'
})
export class Contact {
  public formFields: MailFormControl[] = [
    {
      "control": new FormControl(''),
      "type": "text",
      "label": "First name",
      "placeholder": "",
      "required": true,
      "controlName": "firstName"
    },
    {
      "control": new FormControl(''),
      "type": "text",
      "label": "Last name",
      "placeholder": "",
      "required": true,
      "controlName": "lastName"
    },
    {
      "control": new FormControl(''),
      "type": "email",
      "label": "E-mail",
      "placeholder": "example@gmail.com",
      "required": true,
      "controlName": "email"
    },
    {
      "control": new FormControl(''),
      "type": "phone",
      "label": "Phone",
      "placeholder": "+(XX) XXXXX-XXXX",
      "required": false,
      "controlName": "phone"
    },
    {
      "control": new FormControl(''),
      "type": "text",
      "label": "Subject",
      "placeholder": "",
      "required": true,
      "controlName": "subject"
    },
    {
      "control": new FormControl(''),
      "type": "textarea",
      "label": "Message",
      "placeholder": "",
      "required": true,
      "controlName": "message"
    }
  ];

  public form: FormGroup;

  constructor(public formBuilder: FormBuilder) {
    this.form = formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      phone: [''],
      subject: ['', Validators.required],
      message: ['', Validators.required]
    });
  }

}
