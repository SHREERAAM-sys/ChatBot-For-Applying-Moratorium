import { TestBed } from '@angular/core/testing';

import { BotApplicationService } from './bot-application.service';

describe('BotApplicationService', () => {
  let service: BotApplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BotApplicationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
