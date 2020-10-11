import { TestBed } from '@angular/core/testing';

import { OauthRegistrationServiceService } from './oauth-registration-service.service';

describe('OauthRegistrationServiceService', () => {
  let service: OauthRegistrationServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OauthRegistrationServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
