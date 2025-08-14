import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StandardLightParagraph } from './standard-light-paragraph';

describe('StandardLightParagraph', () => {
  let component: StandardLightParagraph;
  let fixture: ComponentFixture<StandardLightParagraph>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StandardLightParagraph]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StandardLightParagraph);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
