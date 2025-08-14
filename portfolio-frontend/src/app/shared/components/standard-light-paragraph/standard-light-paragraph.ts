import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-standard-light-paragraph',
  imports: [],
  templateUrl: './standard-light-paragraph.html',
  styleUrl: './standard-light-paragraph.scss'
})
export class StandardLightParagraph {
  @Input() text!: string;
}
