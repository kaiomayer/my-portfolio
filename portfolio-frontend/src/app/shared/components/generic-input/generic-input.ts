import { Component, Input } from '@angular/core';
import {FormControl, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-generic-input',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './generic-input.html',
  styleUrl: './generic-input.scss'
})
export class GenericInput {
  @Input() inputType: string = 'text';
  @Input() placeholder: string = '';
  @Input() label: string = '';
  @Input() disabled: boolean = false;
  @Input() id: string = `id-${crypto.randomUUID()}`;
  @Input() control!: FormControl;
}
