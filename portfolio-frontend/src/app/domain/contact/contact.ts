import { Component } from '@angular/core';
import {Hero} from '../../core/layout/hero/hero';
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {GenericInput} from '../../shared/components/generic-input/generic-input';
import {MailFormControl} from '../../shared/models/mailFormControl.model';

@Component({
  selector: 'app-contact',
  imports: [
    Hero,
    FormsModule,
    ReactiveFormsModule,
    GenericInput
  ],
  templateUrl: './contact.html',
  styleUrl: './contact.scss'
})
export class Contact {
  public formFields: MailFormControl[] = [
    {
      "control": new FormControl('firstName'),
      "type": "text",
      "label": "First name",
      "placeholder": "",
      "required": true
    },
    {
      "control": new FormControl('lastName'),
      "type": "text",
      "label": "Last name",
      "placeholder": "",
      "required": true
    },
    {
      "control": new FormControl('email'),
      "type": "email",
      "label": "E-mail",
      "placeholder": "example@gmail.com",
      "required": true
    },
    {
      "control": new FormControl('phone'),
      "type": "phone",
      "label": "Phone",
      "placeholder": "+(XX) XXXXX-XXXX",
      "required": false
    },
    {
      "control": new FormControl('subject'),
      "type": "text",
      "label": "Subject",
      "placeholder": "",
      "required": true
    },
    {
      "control": new FormControl('message'),
      "type": "textarea",
      "label": "Message",
      "placeholder": "",
      "required": true
    }
  ];

  public form: FormGroup;

  constructor(public formBuilder: FormBuilder) {
    this.form = formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      phone: ['', Validators.required],
      subject: ['', Validators.required],
      message: ['', Validators.required]
    });
  }
}
