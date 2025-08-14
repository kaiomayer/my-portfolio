import { Component, Input } from '@angular/core';
import {StandardLightParagraph} from '../../../shared/components/standard-light-paragraph/standard-light-paragraph';
import 'animate.css'

@Component({
  selector: 'app-hero',
  imports: [
    StandardLightParagraph
  ],
  templateUrl: './hero.html',
  styleUrl: './hero.scss'
})
export class Hero {
  @Input() title!: string;
  @Input() description!: string;
}
