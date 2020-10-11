import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OauthRegistrationComponent } from './oauth-registration.component';

describe('OauthRegistrationComponent', () => {
  let component: OauthRegistrationComponent;
  let fixture: ComponentFixture<OauthRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OauthRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OauthRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
