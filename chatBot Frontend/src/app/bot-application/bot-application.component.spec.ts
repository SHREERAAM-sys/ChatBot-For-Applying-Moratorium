import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BotApplicationComponent } from './bot-application.component';

describe('BotApplicationComponent', () => {
  let component: BotApplicationComponent;
  let fixture: ComponentFixture<BotApplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BotApplicationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BotApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
